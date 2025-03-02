package lesson20.model;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
//    @IdClass(Con.class)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "boss_id")
    private Integer bossId;
}