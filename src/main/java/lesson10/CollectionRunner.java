package lesson10;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionRunner {
    public static void main(String[] args) {
        List<String> words = List.of("Hello", "ergergAnton", "Aksyonov", "Aksyonov");
        Stream<String> stream = words.stream();
        Stream<String> stream2 = Stream.of("Hello", "Anton", "Aksyonov");
        System.out.println(stream2.count());
        stream = words.stream();
        System.out.println(stream.count());
        System.out.println(words.size());
        System.out.println(words.size());

        Stream<Integer> integerStream = words.stream().map(Function.identity())
//                .map(it -> it.length())
                .map(String::length)
                .filter(it -> it >= 6)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(1);
//        List<Integer> list = integerStream.toList();
//        System.out.println(list);
//        List<Integer> list = integerStream.collect(Collectors.toList());
//        Set<Integer> list = integerStream.collect(Collectors.toSet());
        List<Integer> list = integerStream.collect(Collectors.toList());
        list.add(1);
        list.add(100);

        System.out.println(list);
    }
}
