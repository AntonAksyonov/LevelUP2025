package homework10.topwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            Map topWordsMap = Arrays.stream(scanner.nextLine()
                            .toLowerCase()
                            .replaceAll("[^а-яёa-z\\s]", "")
                            .replaceAll("\\s{2,}", " ")
                            .split(" "))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println("Слова и частота появления в тексте:");
            System.out.println(topWordsMap);
            List<Map.Entry<String, Long>> topWordsList = new ArrayList<>(topWordsMap.entrySet());
            topWordsList.sort(Map.Entry.<String, Long>comparingByValue().reversed());
            System.out.println("Слова часто встречающиеся в тексте (в порядке убывания частоты появления):");
            topWordsList.stream().limit(7).forEach(it -> System.out.println(it.getKey()));
        }
    }
}
