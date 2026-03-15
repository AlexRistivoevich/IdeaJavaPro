package lesson4.cityBase.service;

import lesson4.cityBase.dao.CityRepository;
import lesson4.cityBase.dao.RegionRepository;
import lesson4.cityBase.dao.model.City;
import lesson4.cityBase.dao.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityBaseService {

    private final CityRepository cityRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public void addRegion(String code, String name) {

        Region region = new Region();
        region.setRegionCode(code);
        region.setRegionNameEn(name);

        regionRepository.save(region);
    }

    @Transactional
    public void addCity(String code, String nameEn, String nameRu, Long population, Integer regionId) {

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));

        City city = new City();
        city.setCode(code);
        city.setNameEn(nameEn);
        city.setNameRu(nameRu);
        city.setPopulation(population);
        city.setRegion(region);

        cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public Page<City> getCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Transactional
    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}