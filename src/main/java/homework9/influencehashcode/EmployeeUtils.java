package homework9.influencehashcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class EmployeeUtils {

    private static long startTime;
    private static long endTime;

    public static void runTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void stopTimer(String message) {
        endTime = System.currentTimeMillis();
        System.out.println(message + (endTime - startTime) + " мс");
    }

    public static void printEmployee(Collection<Employee> employees, int workAge) {
        int count = 0;
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = iterator.next();
            if (employee.getWorkExperience() == workAge) {
                count++;
            }
        }
        System.out.println("Количество работников со стажем работы %d: %d".formatted(workAge, count));
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

    public static String generateFio() {
        return generateFio(2);
    }

    private static final String[][] fioArray = new String[][]{
            new String[]{
                    "Маврии", "Мавринский", "Мавроди", "Мавродиев", "Мавродий", "Мавродин", "Маврыкин",
                    "Маврычев", "Магеркин", "Магеря", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов",
                    "Новиков", "Морозов", "Петров", "Волков", "Соловьёв"
            },
            new String[]{
                    "Абакум", "Абрам", "Абросим", "Аввакум", "Август", "Авдей", "Авдий", "Авель",
                    "Авенир", "Аверий", "Тарас", "Тарх", "Тимофей", "Тимур", "Тит", "Тихон", "Трифон",
                    "Трофим", "Урбан", "Фёдор"
            },
            new String[]{
                    "Ибрагимович", "Иванович", "Иваныч", "Ивсталинович", "Игнатович", "Игнатьевич",
                    "Игоревич", "Измаилович", "Изотович", "Израилевич", "Александрович", "Алексеевич", "Анатольевич",
                    "Андреевич", "Антонович", "Аркадьевич", "Артемович", "Бедросович", "Богданович", "Борисович"
            }
    };

    private static String generateFio(int indexFio) {
        int index = (int) (Math.random() * 19);
        if (indexFio > 0) {
            return generateFio(indexFio - 1) + " " + fioArray[indexFio][index];
        } else {
            return fioArray[indexFio][index];
        }
    }

    public static void generateEmployees(int size, Collection<Employee> employees) throws Exception {
        if (size <= 0) {
            throw new RuntimeException("Размер коллекции должен быть больше 0");
        }
        for (int index = 0; index < size; index++) {
            employees.add(new Employee(generateFio(), String.valueOf(1000 + index), (int) (Math.random() * 40)));
        }
    }
}
