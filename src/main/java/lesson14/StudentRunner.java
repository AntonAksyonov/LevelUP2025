package lesson14;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StudentRunner {

    //    @SneakyThrows({MalformedURLException.class, IOException.class})
    public static void main(String[] args) {
        Student student = new Student("");
        try {
            File file = new File("");
            URL url = file.toURL();
            File canonicalFile = file.getCanonicalFile();
        } catch (IOException e) {
//            throw e;
        }
        System.out.println(ConverterUtil.convert(100L));
        System.out.println(ConverterUtil.MAX);
//        System.out.println(MAX);
    }
}