package lesson12.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class SerializationEmployeeRunner {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("Aksyonov Anton", 20, new Position(1L, "Expert", new BigDecimal("100000")));

        try (
        FileOutputStream fileOutputStream = new FileOutputStream("src/resources/emloyee.data");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        ) {
            oos.writeObject(employee);
        }
    }
}
