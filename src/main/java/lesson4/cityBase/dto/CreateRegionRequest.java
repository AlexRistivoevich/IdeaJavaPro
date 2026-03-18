package lesson4.cityBase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRegionRequest {

    @NotBlank(message = "Код региона обязателен")
    @Size(max = 10, message = "Код региона должен быть не длиннее 10 символов")
    private String code;

    @NotBlank(message = "Название региона обязательно")
    @Size(max = 255, message = "Название региона должно быть не длиннее 255 символов")
    private String name;
}