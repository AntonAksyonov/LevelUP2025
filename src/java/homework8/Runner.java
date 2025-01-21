package homework8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) throws Exception {
        ArrayList<Employee> arrayListEmployees = new ArrayList<>();
        EmployeeUtils.setEmployees(100, arrayListEmployees);
        LinkedList<Employee> linkedListForArrayList = new LinkedList<>(arrayListEmployees);

        LinkedList<Employee> linkedListEmployees = new LinkedList<>();
        EmployeeUtils.setEmployees(100, linkedListEmployees);

        Set<Employee> treeSetEmployees = new TreeSet<>();
        EmployeeUtils.setEmployees(100, treeSetEmployees);
        LinkedList<Employee> linkedListForTreeSet = new LinkedList<>(treeSetEmployees);

        System.out.println(arrayListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(arrayListEmployees, 10);
        EmployeeUtils.deleteEmployee(linkedListForArrayList);
        arrayListEmployees = new ArrayList<>(linkedListForArrayList);
        System.out.println(arrayListEmployees);
        System.out.println(arrayListEmployees.size());
        System.out.println("----");

        System.out.println(linkedListEmployees.getClass().getName());
        EmployeeUtils.printEmployee(linkedListEmployees, 10);
        EmployeeUtils.deleteEmployee(linkedListEmployees);
        System.out.println(linkedListEmployees);
        System.out.println(linkedListEmployees.size());
        System.out.println("----");

        System.out.println(treeSetEmployees.getClass().getName());
        EmployeeUtils.printEmployee(treeSetEmployees, 10);
        EmployeeUtils.deleteEmployee(linkedListForTreeSet);
        treeSetEmployees = new TreeSet<>(linkedListForTreeSet);
        System.out.println(treeSetEmployees);
        System.out.println(treeSetEmployees.size());
        System.out.println("----");
    }
}
