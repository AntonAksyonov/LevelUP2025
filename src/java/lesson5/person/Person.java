package lesson5.person;

import jdk.jshell.Snippet;
import lessons6.PersonalAccount;

public abstract class Person  extends Human{
    Gender gender; //false - male, true - female

    public Person(String name, int age, Gender gender) {
        super(name, age);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public void think() {
        System.out.println("Think!");
    }
}
