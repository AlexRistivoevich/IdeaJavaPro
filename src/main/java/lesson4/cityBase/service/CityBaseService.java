package lesson4.cityBase.service;

import lesson4.cityBase.dao.CityRepository;
import lesson4.cityBase.dao.RegionRepository;
import lesson4.cityBase.dao.model.City;
import lesson4.cityBase.dao.model.Region;
import lesson4.cityBase.dto.CreateCityRequest;
import lesson4.cityBase.dto.CreateRegionRequest;
import lesson4.cityBase.exception.BadRequestException;
import lesson4.cityBase.exception.NotFoundException;
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
    public Region addRegion(CreateRegionRequest request) {
        Region region = new Region();
        region.setRegionCode(request.getCode());
        region.setRegionNameEn(request.getName());
        return regionRepository.save(region);
    }

    @Transactional
    public City addCity(CreateCityRequest request) {
        if (cityRepository.findByCode(request.getCode()).isPresent()) {
            throw new BadRequestException("Город с кодом " + request.getCode() + " уже существует");
        }

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new NotFoundException("Регион с id=" + request.getRegionId() + " не найден"));

        City city = new City();
        city.setCode(request.getCode());
        city.setNameEn(request.getNameEn());
        city.setNameRu(request.getNameRu());
        city.setPopulation(request.getPopulation());
        city.setRegion(region);

        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public Page<City> getCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Transactional
    public void deleteCity(Integer id) {
        if (!cityRepository.existsById(id)) {
            throw new NotFoundException("Город с id=" + id + " не найден");
        }
        cityRepository.deleteById(id);
    }
}