package lessons6;

import java.math.BigDecimal;

public class InterfaceRunner {
    public static void main(String[] args) {
        RussianPersonalAccount russianPersonalAccount = new RussianPersonalAccount(BigDecimal.ZERO);
        Withdrawable withdrawableAccount = russianPersonalAccount;
        withdrawableAccount.withdraw(9);

        HasDeposit hasDepositAccount = russianPersonalAccount;
        hasDepositAccount.deposit(1000);

        Printable printable = russianPersonalAccount;
        printable.print();

        Object convert = convert(russianPersonalAccount);
        Withdrawable withdrawableConvert = convert(russianPersonalAccount);
        HasDeposit hasDepositConvert = convert(russianPersonalAccount);
        convert(russianPersonalAccount).print();
    }

    public static <T extends Withdrawable & HasDeposit & Printable> T convert(RussianPersonalAccount account) {
        return (T) account;
    }

//    public static T convert(<T super Withdrawable>T account) {
//        return (T) account;
//    }
}
