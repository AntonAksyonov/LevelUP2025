package homework8;

import java.util.*;

public class EmployeeUtils {

    public static void printEmployee(Collection<Employee> employees, int workAge) {
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            if (employee.getWorkExperience() == workAge) {
                System.out.println("Стаж работы %d у работника %s".formatted(workAge, employee.getFio()));
            }
        }
    }

    public static void deleteEmployee(LinkedList<Employee> employees) {
        for (ListIterator<Employee> listIterator = employees.listIterator(employees.size()); listIterator.hasPrevious(); ) {
            int index = listIterator.previousIndex();
            Employee employee = listIterator.previous();
            if (index % 2 != 0) {
                listIterator.remove();
            }
        }
    }

    private static String setFIO() {
        return setFIO(2);
    }

    private static String[][] fioArray = new String[3][10];

    private static void initFioArray() {
        fioArray[0] = new String[]{"Маврии", "Мавринский", "Мавроди", "Мавродиев", "Мавродий", "Мавродин", "Маврыкин"
                , "Маврычев", "Магеркин", "Магеря"};
        fioArray[1] = new String[]{"Абакум", " Абрам", " Абросим", " Аввакум", " Август", " Авдей", " Авдий", " Авель"
                , " Авенир", " Аверий"};
        fioArray[2] = new String[]{"Ибрагимович", "Иванович", "Иваныч", "Ивсталинович", "Игнатович", "Игнатьевич"
                , "Игоревич", "Измаилович", "Изотович", "Израилевич"};
    }

    private static String setFIO(int indexFIO) {
        int index = (int) (Math.random() * 9);
        if (indexFIO > 0) {
            return setFIO(indexFIO - 1) + " " + fioArray[indexFIO][index].trim();
        } else {
            return fioArray[indexFIO][index].trim();
        }
    }

    public static void setEmployees(int size, Collection<Employee> employees) throws Exception {
        if (size <= 0) {
            throw new Exception("Размер коллекуии должен быть больше 0");
        }
        initFioArray();
        for (int index = 0; index < size; index++) {
            employees.add(new Employee(setFIO(), String.valueOf(1000 + index), (int) (Math.random() * 40)));
        }
    }
}
