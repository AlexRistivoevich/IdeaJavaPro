package lesson4.cityBase.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "regions")
@Getter
@Setter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "region_code", length = 10, nullable = false)
    private String regionCode;

    @Column(name = "region_name_en", length = 255, nullable = false)
    private String regionNameEn;

    @OneToMany(mappedBy = "region")
    @JsonIgnore
    private List<City> cities;
}