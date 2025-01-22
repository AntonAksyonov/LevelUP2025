package lesson6;

import java.math.BigDecimal;

public class RussianPersonalAccount  extends PersonalAccount implements Cloneable{

    int[] array;

    public RussianPersonalAccount() {
        System.out.println("Открываем русский персональный счёт");
    }

    public RussianPersonalAccount(BigDecimal value) {

        super(6, value);
    }

    public RussianPersonalAccount(BigDecimal value, int[] array) {
        this(value);
        this.array = array;
    }

    public RussianPersonalAccount(RussianPersonalAccount original) {
        this.array = new int[original.array.length];
        for (int index = 0; index < original.array.length; index++) {
            this.array[index] = original.array[index];
        }
        this.balance = original.balance;
    }

    public int[] getArray() {

        return array;
    }

    @Override
    public RussianPersonalAccount clone() throws CloneNotSupportedException {
        RussianPersonalAccount result  = (RussianPersonalAccount) super.clone();
        result.array = new int[result.array.length];
        for (int index = 0; index < result.array.length; index++) {
            result.array[index] = this.array[index];
        }
        return result;
    }

}
