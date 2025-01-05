package HomeWork4;

public class Parrot extends Pet {
    private int learnedWords;

    public Parrot(String name, int age, boolean hungry) {
        super(name, age, hungry);
        this.learnedWords = 2;
    }

    public void lernWord() {
        this.learnedWords++;
    }

    @Override
    public void makeNoise() {
        System.out.println("Принадлежность к классу Parrot");
        System.out.println("Кеша умный");
    }

    @Override
    public boolean eat() {
        System.out.println("Принадлежность к классу Parrot");
        return super.eat();
    }

    @Override
    public void sleep() {
        System.out.println("Принадлежность к классу Parrot");
        super.sleep();
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", hungry=" + this.isHungry() +
                ", learnedWords=" + learnedWords +
                '}';
    }
}
