package homework13.account;

import java.math.BigDecimal;

public interface Withdrawable {
    @Blocked("Операция снятия заблокирована")
    void withdraw(BigDecimal money);

}
