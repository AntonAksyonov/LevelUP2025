package HomeWork4;

public class Pet {
    private String name;
    private int age;
    private boolean hungry;

    public Pet(String name, int age, boolean hungry) {
        this.name = name;
        this.age = age;
        this.hungry = hungry;
    }

    public void makeNoise() {
        System.out.println("Звук издаваемый животным");
    }

    public boolean eat() {
        if (this.hungry) {
            this.hungry = false;
            return true;
        }
        return false;
    }

    public void sleep() {
        this.hungry = true;
    }

    public boolean isHungry() {
        return hungry;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
