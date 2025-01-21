package homework8;

import java.util.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<Employee> arrayListEmployees = new ArrayList<>();
        EmployeeUtils.generateEmployees(100, arrayListEmployees);
        List<Employee> linkedListForArrayList = new LinkedList<>(arrayListEmployees);

        List<Employee> linkedListEmployees = new LinkedList<>();
        EmployeeUtils.generateEmployees(100, linkedListEmployees);

        Set<Employee> treeSetEmployees = new TreeSet<>();
        EmployeeUtils.generateEmployees(100, treeSetEmployees);
        List<Employee> linkedListForTreeSet = new LinkedList<>(treeSetEmployees);

        System.out.println(arrayListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(arrayListEmployees, 10);
        EmployeeUtils.deleteEmployee((LinkedList)linkedListForArrayList);
        arrayListEmployees = new ArrayList<>(linkedListForArrayList);
        System.out.println(arrayListEmployees);
        System.out.println(arrayListEmployees.size());
        System.out.println("----");

        System.out.println(linkedListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(linkedListEmployees, 10);
        EmployeeUtils.deleteEmployee((LinkedList)linkedListEmployees);
        System.out.println(linkedListEmployees);
        System.out.println(linkedListEmployees.size());
        System.out.println("----");

        System.out.println(treeSetEmployees.getClass().getName());
        EmployeeUtils.printEmployee(treeSetEmployees, 10);
        EmployeeUtils.deleteEmployee((LinkedList)linkedListForTreeSet);
        treeSetEmployees = new TreeSet<>(linkedListForTreeSet);
        System.out.println(treeSetEmployees);
        System.out.println(treeSetEmployees.size());
        System.out.println("----");
    }
}
