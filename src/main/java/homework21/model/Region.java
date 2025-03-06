package homework21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regions_seq_gen")
    @SequenceGenerator(name = "regions_seq_gen", sequenceName = "regions_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Region(String code, String name) {
        this(null, code, name);
    }
}
