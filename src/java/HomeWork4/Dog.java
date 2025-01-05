package HomeWork4;

public class Dog extends Pet {
    private int balanceWalksDay;

    public Dog(String name, int age, boolean hungry) {
        super(name, age, hungry);
        this.balanceWalksDay = 2;
    }

    public void walk() {
        this.balanceWalksDay--;
    }

    @Override
    public void makeNoise() {
        System.out.println("Принадлежность к классу Dog");
        System.out.println("Гав");
    }

    @Override
    public boolean eat() {
        System.out.println("Принадлежность к классу Dog");
        return super.eat();
    }

    @Override
    public void sleep() {
        System.out.println("Принадлежность к классу Dog");
        this.balanceWalksDay = 2;
        super.sleep();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", hungry=" + this.isHungry() +
                ", balanceWalksDay=" + balanceWalksDay +
                '}';
    }
}
