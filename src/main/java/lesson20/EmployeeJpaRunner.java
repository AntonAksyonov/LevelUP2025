package lesson20;

import lesson20.impl.EmployeeJpaDaoImpl;

public class EmployeeJpaRunner {

    private static final EmployeeDao dao = new EmployeeJpaDaoImpl();

    public static void main(String[] args) {
        System.out.println(dao.findAll());
    }
}