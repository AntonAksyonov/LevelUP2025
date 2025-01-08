package lesson5.person;

public abstract class Human {
    String name;
    int age;

    protected Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void happyBirthday() {
        age++;
    }

    public abstract void think();
    protected abstract void work();
}
