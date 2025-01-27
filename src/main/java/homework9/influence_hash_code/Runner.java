package homework9.influence_hash_code;

import java.util.*;

public class Runner {
    public static void main(String[] args) throws Exception {

        Employee.setEgualHashCode(true);

        EmployeeUtils.runTimer();
        List<Employee> arrayListEmployees = new ArrayList<>();
        EmployeeUtils.generateEmployees(10000, arrayListEmployees);
        EmployeeUtils.stopTimer("Время генерации коллекции с типом %s составило: "
                .formatted(arrayListEmployees.getClass().getName()));

        EmployeeUtils.runTimer();
        List<Employee> linkedListEmployees = new LinkedList<>(arrayListEmployees);
        EmployeeUtils.stopTimer("Время генерации коллекции с типом %s составило: "
                .formatted(linkedListEmployees.getClass().getName()));

        EmployeeUtils.runTimer();
        Set<Employee> treeSetEmployees = new TreeSet<>(arrayListEmployees);
        EmployeeUtils.stopTimer("Время генерации коллекции с типом %s составило: "
                .formatted(treeSetEmployees.getClass().getName()));

        EmployeeUtils.runTimer();
        System.out.println(arrayListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(arrayListEmployees, 11);
        EmployeeUtils.stopTimer("Время обработки коллекции с типом %s составило: "
                .formatted(arrayListEmployees.getClass().getName()));
        System.out.println("----");

        EmployeeUtils.runTimer();
        System.out.println(linkedListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(linkedListEmployees, 11);
        EmployeeUtils.stopTimer("Время обработки коллекции с типом %s составило: "
                .formatted(linkedListEmployees.getClass().getName()));
        System.out.println("----");

        EmployeeUtils.runTimer();
        System.out.println(treeSetEmployees.getClass().getName());
        EmployeeUtils.printEmployee(treeSetEmployees, 11);
        EmployeeUtils.stopTimer("Время обработки коллекции с типом %s составило: "
                .formatted(treeSetEmployees.getClass().getName()));
        System.out.println("----");
    }
}
