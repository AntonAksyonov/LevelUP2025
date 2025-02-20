package lesson17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedCollectionRunner {
    public static void main(String[] args) {
        List<String> words = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            words.add("word" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                String word = "word" + words.size();
                System.out.println("Добавлено слово " + word);
                words.add(word);
            });

            executorService.submit(() -> {
                int index = new Random().nextInt(words.size() - 1);
                System.out.println("Удалено слово с индексом " + index);
                words.remove(index);
            });
        }

        System.out.println(words);

        executorService.shutdownNow();

        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        Map<String, Integer> concurrentHashMap = Collections.synchronizedMap(new HashMap<>());
    }
}