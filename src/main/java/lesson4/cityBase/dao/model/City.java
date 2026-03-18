package lesson4.cityBase.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(length = 10, nullable = false)
    private String code;

    @Column(name = "name_en", length = 255, nullable = false)
    private String nameEn;

    @Column(name = "name_ru", length = 255, nullable = false)
    private String nameRu;

    @Column(nullable = false)
    private Long population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    @JsonIgnoreProperties("cities")
    private Region region;
}