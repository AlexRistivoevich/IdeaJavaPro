package lesson4.cityBase.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_ru")
    private String nameRu;

    private Long population;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}