package lesson6;

public interface Withdrawable {
    void withdraw(long money);

    default void withdraw() {
        withdraw(1000);
    }

//    default void print() {
//        System.out.println(this);
//    }

//    static void printHelloWorld() {
//        System.out.println("Hello, World");
//    }
}
