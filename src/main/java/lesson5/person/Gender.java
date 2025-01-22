package lesson5.person;

public enum Gender {

    MALE(true), FEMALE(false);

    private boolean isProlonged;

    Gender() {
        this.isProlonged = false;
    }

    Gender(boolean isProlonged) {
        this.isProlonged = isProlonged;
    }

    public boolean isProlong() {
//        return MALE.equals(this);
        return isProlonged;
    }
}
