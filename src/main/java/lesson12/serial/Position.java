package lesson12.serial;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public record Position(Long id, String name, BigDecimal salary) implements HasMoney, Serializable {

    @Override
    public boolean hasMoney() {
        return !Objects.equals(salary, BigDecimal.ZERO);
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }
}