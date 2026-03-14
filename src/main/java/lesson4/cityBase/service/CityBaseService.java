package lesson4.cityBase.service;

import lesson4.cityBase.dao.CityDao;
import lesson4.cityBase.dao.RegionDao;
import lesson4.cityBase.dao.model.City;
import lesson4.cityBase.dao.model.Region;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityBaseService {

    private final CityDao cityDao;
    private final RegionDao regionDao;

    public CityBaseService(CityDao cityDao, RegionDao regionDao) {
        this.cityDao = cityDao;
        this.regionDao = regionDao;
    }

    @Transactional
    public void addRegion(String regionCode, String regionName) {
        Region region = new Region();
        region.setRegionCode(regionCode);
        region.setRegionNameEn(regionName);
        regionDao.save(region);
    }

    @Transactional
    public void addCity(String code, String nameEn, String nameRu, Long population, Integer regionId) {
        Region region = regionDao.findById(regionId).orElseThrow(() -> new IllegalArgumentException("Region not found"));
        City city = new City();
        city.setCode(code);
        city.setNameEn(nameEn);
        city.setNameRu(nameRu);
        city.setPopulation(population);
        city.setRegion(region);
        cityDao.save(city); // Здесь добавляем сохранение
    }

    @Transactional(readOnly = true)
    public List<City> getAllCities() {
        return cityDao.findAll();
    }
}