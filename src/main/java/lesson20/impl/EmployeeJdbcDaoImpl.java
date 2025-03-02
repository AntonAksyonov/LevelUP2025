package lesson20.impl;

import lesson19.Employee;
import lesson19.util.DbHelper;
import lesson20.EmployeeDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeJdbcDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        //language=SQL
        String sql = "select id, name, position_id from employees";
        try (PreparedStatement preparedStatement = DbHelper.createPreparedStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                ));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        //language=SQL
        String sql = """
                select id, name, position_id from employees
                where id = ?
                """;
        try (PreparedStatement preparedStatement = DbHelper.createPreparedStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)
                ));
            }
            return employees.stream().findFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Employee employee) {
        //language=SQL
        boolean created = employee.getId() == -1;
        String sql = created
                ? """
                insert into employees (name, position_id)
                values (?, ?)
                """
                : """
                update employees set name = ?, position_id = ?
                where id = ?
                """;
        try (PreparedStatement preparedStatement = DbHelper.createPreparedStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getPositionId());
            if (!created) {
                preparedStatement.setInt(3, employee.getId());
            }
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Employee employee) {
        //language=SQL
        String sql = """
                delete from employees
                where id = ?
                """;
        try (PreparedStatement preparedStatement = DbHelper.createPreparedStatement(sql)) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.executeUpdate();
            preparedStatement.getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}