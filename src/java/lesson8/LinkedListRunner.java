package lesson8;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class LinkedListRunner {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {

            numbers.add(i);
        }
        System.out.println(numbers);

        ListIterator<Integer> integerListIterator =  numbers.listIterator();
        if (integerListIterator.hasPrevious()) {
            Integer previous = integerListIterator.previous();
        }

        List<Boolean> booleans = new Vector<>();
    }
}
