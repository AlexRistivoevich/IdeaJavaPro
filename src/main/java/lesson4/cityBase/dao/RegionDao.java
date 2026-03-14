package lesson4.cityBase.dao;

import lesson4.cityBase.dao.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionDao extends JpaRepository<Region, Integer> {
}