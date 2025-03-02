package lesson20;

import lesson19.Employee;
import lesson20.impl.EmployeeJdbcDaoImpl;

import java.util.List;

public class EmployeeRunner {

    private static final EmployeeDao dao = new EmployeeJdbcDaoImpl();

    public static void main(String[] args) {
        List<Employee> all = dao.findAll();
        System.out.println(all);
        System.out.println(all.size());

        System.out.println(dao.findById(1));

        Employee employee = new Employee(31, "New Employee!!!!!!!!", 100);
        dao.save(employee);

        System.out.println(dao.findAll().size());

        dao.delete(employee);
        System.out.println(dao.findAll().size());
    }
}