package lessons6.jenerics;

public class State {
    String name;

    public State(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
