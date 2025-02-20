package lesson13.lombok;

import java.math.BigDecimal;

public class LombokRunner {

    public static void main(String[] args) {
        CustomEntity result = new CustomEntity(12);
        System.out.println(CustomEntity.Fields.id);

        CustomEntity customEntity = new CustomEntity(10, "Petr", BigDecimal.TEN, null, false);
//        customEntity.setId(10);
        customEntity.setName("Vitaly").setFlag(true);
        System.out.println(customEntity.getId());
        System.out.println(customEntity.getName());
        System.out.println(customEntity.getValue());
        System.out.println(customEntity.getFlag());
        System.out.println(customEntity.getAccount());

        System.out.println(result);
        System.out.println(customEntity);
    }
}