package HomeWork4;

public class Owner {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурка", 2, true);
        Dog dog = new Dog("Шарик", 4, false);
        Parrot parrot = new Parrot("Чип", 1, true);

        Pet[] pets = {cat, dog, parrot};
        feedsPets(pets);

        cat.sleep();
        cat.jumpFromHeight();

        dog.sleep();
        dog.walk();

        parrot.sleep();
        parrot.lernWord();

        pets[0] = cat;
        pets[1] = dog;
        pets[2] = parrot;
        feedsPets(pets);
    }

    private static void feedsPets(Pet[] pets) {
        boolean eat;
        for (Pet pet : pets) {
            eat = pet.eat();
            System.out.println(pet.toString() + " - " + (!eat ? "не " : "") + "поел");
        }
    }

}
