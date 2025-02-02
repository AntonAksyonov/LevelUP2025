package homework12;

import homework12.account.Account;
import homework12.account.AccountUtils;
import homework12.client.ClientUtils;
import homework12.client.Company;
import homework12.client.Personal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AccountRunner {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Personal personal = ClientUtils.createPersonal(
                "Aksyonov Anton Nikolaevich",
                "2158125458152",
                LocalDateTime.of(LocalDate.of(1988, 7, 13), LocalTime.of(0, 0)),
                "1234", "567890"
        );

        Account personalAccount = AccountUtils.openingAccount("4581584845", new BigDecimal("100.4"), personal);

        AccountUtils.printing(personalAccount);

        Company company = ClientUtils.createCompany(
                "АО Компания №1",
                "657846154856",
                "Акционерное Общество Компания №1",
                "5684",
                "21518"
        );

        Account companyAccount = AccountUtils.openingAccount("69874531", new BigDecimal("10000.66"), company);

        AccountUtils.printing(companyAccount);
    }
}
