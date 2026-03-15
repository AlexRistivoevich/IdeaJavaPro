package lesson4.cityBase.dao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String nameEn;

    private String nameRu;

    private Long population;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}