package lessons6.generics;

public class AccountStarter {
    public static void main(String[] args) {
        Account<Personal> personalAccount = new Account<>(new Personal("Aksyonov Anton"));
        Account<Object> companyAccount = new Account<>(new Company("Level Up"));
        Account<State> stateAccount = new Account<>(new State("Russia"));

        System.out.println(personalAccount.getOwner());
        System.out.println(companyAccount.getOwner());

        companyAccount.setOwner(new State("Russia"));
        System.out.println(companyAccount.getOwner());
    }
}
