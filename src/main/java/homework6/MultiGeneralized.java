package homework6;

import java.io.Serializable;

public class MultiGeneralized<T extends Comparable<T>, V extends Serializable, K extends Number> {
    private T field1;
    private V field2;
    private K field3;

    public MultiGeneralized(T field1, V field2, K field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public T getField1() {
        return field1;
    }

    public V getField2() {
        return field2;
    }

    public K getField3() {
        return field3;
    }

    public void getFieldsClassName() {
        System.out.println("Класс для field1: " + field1.getClass().getName());
        System.out.println("Класс для field2: " + field2.getClass().getName());
        System.out.println("Класс для field3: " + field3.getClass().getName());
    }
}
