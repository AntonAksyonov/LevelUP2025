package lesson19;

import lesson19.util.DbHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DbRunner {

    public static void main(String[] args) throws Exception {
        // мы явно загружаем драйвер
        Class.forName("org.postgresql.Driver");
//        String id = "5 or 1 = 1; drop database postgres;";
        String id = "1";
        List<Employee> employees = new ArrayList<>();
        try (Statement statement = DbHelper.createStatement("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root")
        ) {
            ResultSet resultSet = statement.executeQuery("""
                        select emp.id, emp.name, empl.name as boss_name, emp.position_id
                        from employees emp
                        left join employees empl on emp.boss_id = empl.id
                    """);
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                String bossName = resultSet.getString("boss_name");
                Integer positionId = DbHelper.getInteger(resultSet, "position_id");
                employees.add(new Employee(employeeId, employeeName, bossName, positionId));
            }
        }
        System.out.println(employees);

        System.out.println("-----------");

        List<Employee> filteredEmployees = new ArrayList<>();
        String sql = """
                        select emp.id, emp.name, empl.name as boss_name, emp.position_id
                        from employees emp
                        left join employees empl on emp.boss_id = empl.id
                        where emp.id = ? or emp.name = ? or 1 = 1
                        limit ?
                    """;
        try (PreparedStatement statement = DbHelper.createPreparedStatement("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root", sql)
        ) {
            statement.setInt(1, 1);
            String name = "Ivanov Vitalii or 1 = 1; drop database postgres;";
            statement.setString(2, name);
            statement.setInt(3, 10);
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("Количество колонок в выборке: " + metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.println("Колонка с индексом " + i + " в выборке: " + metaData.getColumnName(i) +
                        " и типом " + metaData.getColumnType(i));
                // все существующие типы перечислены java.sql.Types
            }
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                String bossName = resultSet.getString("boss_name");
                Integer positionId = DbHelper.getInteger(resultSet, "position_id");
                filteredEmployees.add(new Employee(employeeId, employeeName, bossName, positionId));
            }
        }
        System.out.println(filteredEmployees);

        sql = """
                insert into employees (name, boss_id)
                values (?, ?);
                """;
        try (PreparedStatement statement = DbHelper.createPreparedStatement("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root", sql)
        ) {
//            statement.setInt(1, 1);
            for (int index = 0; index < 5; index++) {
                statement.setString(1, "Test Test " + index);
                statement.setInt(2, 1);
                statement.addBatch();
            }
//            int result = statement.executeUpdate();
            int[] ints = statement.executeBatch();
            Optional<Integer> summa = Arrays.stream(ints).boxed().reduce((a, b) -> a + b);
            System.out.println("Количество измененных записей: " + summa.orElse(null));
            statement.getConnection().commit();
        }

        sql = """
                update employees set name = ?
                where id >= ?;
                """;
        try (PreparedStatement statement = DbHelper.createPreparedStatement("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root", sql)
        ) {
            statement.setString(1, "Lastname Name");
            statement.setInt(2, 3);
            int result = statement.executeUpdate();
            System.out.println("Количество измененных записей: " + result);
//            statement.getConnection().commit();
        }
    }


}