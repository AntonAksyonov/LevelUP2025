package lesson11;

import java.util.List;
import java.util.stream.Stream;

public class FigureRunner {
    public static void main(String[] args) {
        List<Figure> figures = List.of(new Figure(1, 2),
                new Figure(10, 6),
                new Figure(100, 200));

        Stream<Integer> integerStream = figures.stream().filter(Figure::isAppropriate).map(Figure::getHeight);

    }
}
