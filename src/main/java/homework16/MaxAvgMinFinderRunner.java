package homework16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MaxAvgMinFinderRunner {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws Exception {
        System.out.println("Начало выполнения программы %s".formatted(DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        long time = System.currentTimeMillis();

        List<Integer> numbers = fill();
        System.out.println("Коллекция заполнена");

        Callable<Integer> maxFinderCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                Integer maxValue = null;
                for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
                    Integer currentValue = iterator.next();
                    maxValue = (maxValue == null || maxValue < currentValue) ? currentValue : maxValue;
                }
                return maxValue;
            }
        };

        Callable<Double> avgFinderCallable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                Integer sumValue = null;
                for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
                    Integer currentValue = iterator.next();
                    sumValue = (sumValue == null || sumValue < currentValue) ? currentValue : sumValue;
                }
                return (double) sumValue / numbers.size();
            }
        };

        Callable<Integer> minFinderCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                Integer minValue = null;
                for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
                    Integer currentValue = iterator.next();
                    minValue = (minValue == null || minValue > currentValue) ? currentValue : minValue;
                }
                return minValue;
            }
        };

        FutureTask<Integer> maxFinderFutureTask = new FutureTask<>(maxFinderCallable);
        new Thread(maxFinderFutureTask).start();

        FutureTask<Double> avgFinderFutureTask = new FutureTask<>(avgFinderCallable);
        new Thread(avgFinderFutureTask).start();

        FutureTask<Integer> minFinderFutureTask = new FutureTask<>(minFinderCallable);
        new Thread(minFinderFutureTask).start();

        try {
            System.out.println("Максимальное значение в коллекции = %d".formatted(maxFinderFutureTask.get()));
            System.out.println("Среднее значение в коллекции = %1$,.5f".formatted(avgFinderFutureTask.get()));
            System.out.println("Минимальное значение в коллекции = %d".formatted(minFinderFutureTask.get()));
        } catch (Exception e) {
            minFinderFutureTask.cancel(true);
            System.out.println("Результат не получен, ошибка: ".formatted(e.getMessage()));
        }

        System.out.println("Программа выполнила свою работу за %d мсек".formatted(System.currentTimeMillis() - time));
    }

    private static LinkedList<Integer> fill() {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(-1000000 + new Random().nextInt(2000001));
        }
        return numbers;
    }
}