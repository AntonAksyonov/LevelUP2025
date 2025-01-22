package lesson6;

public interface Printable {
    default void print() {
        System.out.println(this);
    }

    static void printHelloWorld() {
        System.out.println("Hello, World");
    }
}
