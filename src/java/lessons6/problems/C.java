package lessons6.problems;

public interface C extends A {
    long c();

    default void print() {
        System.out.println("C");
    }
}
