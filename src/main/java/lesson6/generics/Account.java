package lesson6.generics;

public class Account<T> {
    private T owner;
//    private Company ownerCompany;
//    private Personal ownerPerson;


    public Account(T owner) {
        this.owner = owner;
    }

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }
}
