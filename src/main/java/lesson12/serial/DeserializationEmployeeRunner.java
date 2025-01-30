package lesson12.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationEmployeeRunner {

    public static void main(String[] args) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/resources/employee.data"))) {
            Employee employee = (Employee) ois.readObject();
            System.out.println(employee);
        }
    }
}