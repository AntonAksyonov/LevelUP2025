package lesson11;

public class IntHolder {
    private int value;

    public IntHolder() {
        this(0);
    }

    public IntHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }
}
