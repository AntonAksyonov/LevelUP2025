package lessons6.generics;

public class Personal {
    String fullName;

    public Personal(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
