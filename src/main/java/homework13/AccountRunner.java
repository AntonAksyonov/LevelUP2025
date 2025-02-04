package homework13;

import homework13.account.Account;
import homework13.account.AccountUtils;
import homework13.account.Withdrawable;
import homework13.account.WrappedAccount;
import homework13.client.ClientUtils;
import homework13.client.Company;
import homework13.client.Personal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AccountRunner {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Personal personal = ClientUtils.createPersonal(
                "Aksyonov Anton Nikolaevich",
                "2158125458152",
                LocalDateTime.of(LocalDate.of(1988, 7, 13), LocalTime.of(0, 0)),
                "1234", "567890"
        );

        Account personalAccount = AccountUtils.openingAccount("4581584845", new BigDecimal("100.4"), personal);
        AccountUtils.depositOrWithdraw(personalAccount, BigDecimal.TWO, "deposit");
        AccountUtils.printing(personalAccount);

        Company company = ClientUtils.createCompany(
                "АО Компания №1",
                "657846154856",
                "Акционерное Общество Компания №1",
                "5684",
                "21518"
        );

        Account companyAccount = AccountUtils.openingAccount("69874531", new BigDecimal("10000.66"), company);

        Withdrawable proxyAccount = (Withdrawable) Proxy.newProxyInstance(
                companyAccount.getClass().getClassLoader(),
                companyAccount.getClass().getInterfaces(),
                new WrappedAccount(companyAccount)
        );
        proxyAccount.withdraw(BigDecimal.ONE);
//        AccountUtils.depositOrWithdraw(companyAccount, BigDecimal.ONE, "withdraw");

        AccountUtils.printing(companyAccount);
    }
}
