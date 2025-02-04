package homework13.account;

import homework13.client.Client;
import homework13.client.ClientUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AccountUtils {

    public static Account openingAccount(String number, BigDecimal balance, Client client) throws InstantiationException, IllegalAccessException {
        Class<?> aClass = Account.class;
        Account account = (Account) aClass.newInstance();

        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            switch (field.getName()) {
                case "accountNumber": {
                    field.set(account, number);
                    break;
                }
                case "balance": {
                    field.set(account, balance);
                    break;
                }
                case "openedAt": {
                    field.set(account, LocalDateTime.now());
                    break;
                }
                case "owner": {
                    field.set(account, client);
                    break;
                }
            }
        }

        return account;
    }

    public static void printing(Account account) throws IllegalAccessException {
        Arrays.stream(account.getClass().getDeclaredFields()).toList().forEach(fild -> {
            fild.setAccessible(true);
            try {
                System.out.println(fild.getName() + " = " + (fild.getType() == Client.class ? ClientUtils.printing((Client) fild.get(account)) : fild.get(account)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void depositOrWithdraw(Account account, BigDecimal value, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method depositMethod = account.getClass().getMethod(methodName, BigDecimal.class);
        depositMethod.invoke(account, value);
    }

}
