package lesson4.cityBase.dao.model;

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

    private String regionCode;

    private String regionNameEn;

    @OneToMany(mappedBy = "region")
    private List<City> cities;
}