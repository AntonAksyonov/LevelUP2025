package lessons6.problems;

public interface B extends A {
    int b();

    default void print() {
        System.out.println("B");
    }
}
