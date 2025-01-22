package lesson5.figure;

public class FigureRunner {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.square());

        Kvadrat kvadrat = new Kvadrat(10);
        System.out.println(kvadrat.perimeter());
        System.out.println(kvadrat.square());
    }
}
