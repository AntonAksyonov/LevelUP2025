package homework19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

//    private Integer id;
    private String code;
    private String name;
    private String englishName;
    private Integer population;

}
