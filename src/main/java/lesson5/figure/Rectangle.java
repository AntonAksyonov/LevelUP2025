package lesson5.figure;

public class Rectangle {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int perimeter() {
        return 2 * (a + b);
    }

    public int square() {
        return a * b;
    }


}
