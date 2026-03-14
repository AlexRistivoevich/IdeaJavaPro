package lesson4.cityBase.dao;

import lesson4.cityBase.dao.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {
    Optional<City> findByCode(String code);
}