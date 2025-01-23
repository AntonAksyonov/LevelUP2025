package lesson10;

@FunctionalInterface
public interface Moveable {
    void move(int distace);

    default int moveTo(String city) {
        move(1000);
        return 100;
    };
}
