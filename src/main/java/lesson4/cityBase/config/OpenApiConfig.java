package lesson4.cityBase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cityBaseOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("CityBase API")
                        .description("API для работы с городами и регионами")
                        .version("1.0.0"));
    }
}