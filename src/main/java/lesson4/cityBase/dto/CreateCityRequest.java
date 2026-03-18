package lesson4.cityBase.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityRequest {

    @NotBlank(message = "Код города обязателен")
    @Size(max = 10, message = "Код города должен быть не длиннее 10 символов")
    private String code;

    @NotBlank(message = "Английское название обязательно")
    @Size(max = 255, message = "nameEn должен быть не длиннее 255 символов")
    private String nameEn;

    @NotBlank(message = "Русское название обязательно")
    @Size(max = 255, message = "nameRu должен быть не длиннее 255 символов")
    private String nameRu;

    @NotNull(message = "Население обязательно")
    @Positive(message = "Население должно быть больше 0")
    private Long population;

    @NotNull(message = "regionId обязателен")
    @Positive(message = "regionId должен быть больше 0")
    private Integer regionId;
}