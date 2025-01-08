package lesson5.util;

import java.math.BigDecimal;

public class CommissionUtils {
    public static BigDecimal getSummaWitchCommission(BigDecimal value, BigDecimal threshold, BigDecimal commission) {
        if (value.compareTo(threshold) > 0) {
            value = value.add(value.multiply(commission));
        }
        return value;
    }
}
