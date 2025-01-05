package HomeWork4;

public class Cat extends Pet {
    public int remainsLives;

    public Cat(String name, int age, boolean hungry) {
        super(name, age, hungry);
        this.remainsLives = 8;
    }

    public void jumpFromHeight() {
        this.remainsLives--;
    }

    @Override
    public void makeNoise() {
        System.out.println("Принадлежность к классу Cat");
        System.out.println("Мяу");
    }

    @Override
    public boolean eat() {
        System.out.println("Принадлежность к классу Cat");
        return super.eat();
    }

    @Override
    public void sleep() {
        System.out.println("Принадлежность к классу Cat");
        super.sleep();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", hungry=" + this.isHungry() +
                ", remainsLives=" + remainsLives +
                '}';
    }
}
