package lesson5.account;

import lesson5.account.legal.LegalAccount;

import java.math.BigDecimal;

public class AccountLaunch {
    public static void main(String[] args) {
//        Account account = new Account();
        PersonalAccount personalAccount = new PersonalAccount("Aksyonov Anton");
        LegalAccount legalAccount = new LegalAccount("SuperPuper");
//        legalAccount.setOrganization("LevelUp");

//        personalAccount.setFullName("Aksyonov Anton");
        Account personalAccountForClient = new PersonalAccount("Aksyonov Anton");
        Account personalAccountForOrganization = new LegalAccount("RogaAndKopyta");

        ((PersonalAccount) personalAccountForClient).setFullName("Aksyonov Anton");
        ((LegalAccount) personalAccountForOrganization).setOrganization("IP Aksyonov Anton");

        Account[] accounts = {personalAccount, legalAccount};
        for (Account acc : accounts) {
            System.out.println(acc);
            acc.deposit(new BigDecimal("1000000"));
            System.out.println(acc.getBalance());

            acc.withdraw(new BigDecimal("500000"));
            System.out.println(acc.getBalance());
        }
    }
}
