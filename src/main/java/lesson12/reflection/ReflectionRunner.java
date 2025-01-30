package lesson12.reflection;

import lesson12.serial.Employee;
import lesson12.serial.Position;
import lesson6.problems.B;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

public class ReflectionRunner {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee(
                "Ivanov Vitaly", 20,
                new Position(1L, "Expert", new BigDecimal("1000000"))
        );

        Class<Integer> integerClass = int.class;
        Class<? extends Employee> aClass = employee.getClass();
        Class<Employee> employeeClass = Employee.class;
        Class<?> empClass = Class.forName("lesson12.serial.Employee");

        Employee otherEmployee = aClass.newInstance(); // new Employee()

        Constructor<? extends Employee> constructor = aClass.getConstructor();
        Employee defaultConstructEmployee = constructor.newInstance();

        Constructor<? extends Employee> otherConstructor = aClass.getConstructor(String.class, int.class, Position.class);
        Employee constructEmployee = otherConstructor.newInstance("Vitaliy Ivanov", 12, new Position(2L, "JavaDeveloper", new BigDecimal("500000")));

        System.out.println(empClass.getName());
        System.out.println(empClass.getSimpleName());

        System.out.println("----");
        Arrays.asList(empClass.getDeclaredFields()).forEach(it -> {
            System.out.println(it.getName());
        });

        Field serialVersionUidField = empClass.getDeclaredFields()[0];
        serialVersionUidField.setAccessible(true);
        System.out.println("serialVersionUid = " + serialVersionUidField.get(constructEmployee));

        Field fullNameField = empClass.getDeclaredField("fullName");
        fullNameField.setAccessible(true);
        System.out.println("FIO = " + fullNameField.get(constructEmployee));

        System.out.println("----");

        System.out.println("----");
        Arrays.asList(empClass.getDeclaredMethods()).forEach(it -> {
            System.out.println(it.getName());
        });
        System.out.println("----");

        Method getPositionMethod = empClass.getDeclaredMethod("getPosition");
        System.out.println("Position = " + getPositionMethod.invoke(constructEmployee));
        System.out.println("Position = " + getPositionMethod.invoke(employee));

        Method setWorkAgeMethod = empClass.getDeclaredMethod("setWorkAge", int.class);
        setWorkAgeMethod.invoke(constructEmployee, 20);
        System.out.println("WorkAge = " + constructEmployee.getWorkAge());

        System.out.println(Arrays.toString(aClass.getInterfaces()));
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);

        System.out.println(otherEmployee);
        System.out.println(defaultConstructEmployee);
        System.out.println(constructEmployee);

        System.out.println(otherEmployee == defaultConstructEmployee);
    }
}