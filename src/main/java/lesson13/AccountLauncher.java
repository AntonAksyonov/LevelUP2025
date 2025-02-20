package lesson13;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
public class AccountLauncher {
    public static void main(String[] args) {
        LegalAccount levelUpAccount = new LegalAccount(new BigDecimal(50), "LevelUp");
        Withdrawable withdrawable =  (Withdrawable) Proxy.newProxyInstance(
                AccountLauncher.class.getClassLoader(),
                new Class[]{Withdrawable.class},
                new WrappedAccount(levelUpAccount)
        );
        withdrawable.withdraw(BigDecimal.TEN);
        LegalAccount companyAccount = new LegalAccount(BigDecimal.ZERO, "Рога и копыта");
        valid(companyAccount);
    }
    private static void valid(LegalAccount account) {
        if (account.getBalance() == null || account.getOrganization() == null) {
            throw new NullPointerException();
        }
    }
}