package homework21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cities_seq_gen")
    @SequenceGenerator(name = "cities_seq_gen", sequenceName = "cities_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "name")
    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "population")
    private Integer population;

    public City(String code, Region region, String name, String englishName, Integer population) {
        this(null, code, region, name, englishName, population);
    }

}
