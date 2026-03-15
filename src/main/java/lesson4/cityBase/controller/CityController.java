package lesson4.cityBase.controller;

import lesson4.cityBase.dao.model.City;
import lesson4.cityBase.service.CityBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityBaseService cityBaseService;

    @GetMapping
    public Page<City> getCities(Pageable pageable) {
        return cityBaseService.getCities(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id) {
        cityBaseService.deleteCity(id);
    }
}