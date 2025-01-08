package lesson5.person;

public class HumanRunner {
    public static void main(String[] args) {
        Person aksyonovA = new Student("Aksyonov Anton", 36, Gender.MALE);
        aksyonovA.think();
        if (aksyonovA.getGender().isProlong()) {
            aksyonovA.work();
        }
    }
}
