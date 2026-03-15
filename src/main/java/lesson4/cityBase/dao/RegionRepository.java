package lesson4.cityBase.dao;

import lesson4.cityBase.dao.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegionRepository extends JpaRepository<Region, Integer> {
}