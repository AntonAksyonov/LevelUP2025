package lesson11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileRiderRunner {
    private static final String str = "src/resources/text.txt";
    public static void main(String[] args) throws Exception {

        try (BufferedReader fileReader = new BufferedReader(new FileReader(str, StandardCharsets.UTF_8), 1024)) {

            fileReader.lines().forEach(System.out::println);
//            char[] buffer = new char[4];
//            while (fileReader.read(buffer) >= 0) {
//                System.out.println(new String(buffer));
//            };

            fileReader.close();
        }
//        catch (FileNotFoundException fe) {
//            System.out.println("Файл %s не найден".formatted(str));
//        } catch (IOException e) {
//            System.out.println("Файл %s  невозможно протитать".formatted(str));
//        }

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            long value = scanner.nextLong();
            System.out.println("Вы ввели число %d: ".formatted(value));
        }
    }
}
