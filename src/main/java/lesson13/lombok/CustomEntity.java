package lesson13.lombok;

import lesson13.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@RequiredArgsConstructor
@FieldNameConstants
@ToString(exclude = "flag")
public class CustomEntity {

    private final int id;
    private String name;
    private BigDecimal value;
    private Account account;
    private Boolean flag;
}