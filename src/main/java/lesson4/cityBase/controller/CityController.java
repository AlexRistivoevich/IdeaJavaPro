package lesson4.cityBase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lesson4.cityBase.dao.model.City;
import lesson4.cityBase.dao.model.Region;
import lesson4.cityBase.dto.CreateCityRequest;
import lesson4.cityBase.dto.CreateRegionRequest;
import lesson4.cityBase.service.CityBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
@Validated
@Tag(name = "Cities", description = "API для работы с городами")
public class CityController {

    private final CityBaseService cityBaseService;

    @GetMapping
    @Operation(summary = "Получить список городов")
    public Page<City> getCities(Pageable pageable) {
        return cityBaseService.getCities(pageable);
    }

    @PostMapping
    @Operation(summary = "Добавить город")
    public City addCity(@Valid @RequestBody CreateCityRequest request) {
        return cityBaseService.addCity(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить город по id")
    public void deleteCity(@PathVariable @Min(value = 1, message = "id должен быть больше 0") Integer id) {
        cityBaseService.deleteCity(id);
    }

    @PostMapping("/regions")
    @Operation(summary = "Добавить регион")
    public Region addRegion(@Valid @RequestBody CreateRegionRequest request) {
        return cityBaseService.addRegion(request);
    }
}