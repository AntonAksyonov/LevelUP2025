package lesson9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueRunner {
    public static void main(String[] args) {

        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            numbers.offer(i);
        }

        System.out.println(numbers);
        System.out.println(numbers.peek());
        System.out.println(numbers);
        System.out.println(numbers.poll());
        System.out.println(numbers);

        Integer number;
        while ((number = numbers.poll()) != null) {
            System.out.println(number);
        }
        System.out.println(numbers);

        Deque<String> words = new LinkedList<>(List.of("Hello", "World"));
        words.offerFirst("Anton");
        words.offerFirst("Aksyonov");
        words.offerFirst("Test");

        System.out.println(words);
        String word;
        while ((word = words.poll()) != null) {
            System.out.println(word);
        }
        System.out.println(words);

    }
}
