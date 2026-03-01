package lesson2.TemperatureConvector.Service;

import lesson2.TemperatureConvector.Constans.TemperatureScale;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationRunner.class);
        ConverterService converterServiceImpl = applicationContext
                .getBean(ConverterService.class);
        System.out.println(converterServiceImpl
                .convertTemperature(TemperatureScale.CELSIUS, TemperatureScale.KELVIN, -50));
    }
}
