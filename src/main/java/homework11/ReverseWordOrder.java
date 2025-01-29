package homework11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReverseWordOrder {
    public static void main(String... args)  throws IOException {
        String pathRead = "";
        String pathWrite = "";
        for (String str : args) {
            if (pathRead.isEmpty()) {
                pathRead = str;
            } else {
                pathWrite = str;
                break;
            }
        }

        File fileRead = new File(pathRead);
        if (fileRead.exists()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(pathRead, StandardCharsets.UTF_8), 1024);

            String forReturn = Arrays.stream(fileReader.lines()
                            .collect(Collectors.joining(" "))
                            .split("\\s"))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining(" "));
            fileReader.close();
            System.out.println(forReturn);

            if (!pathWrite.isEmpty()) {
                FileWriter fileWriter = new FileWriter(pathWrite);
                fileWriter.write(forReturn);
                fileWriter.close();
            }
        }
    }
}
