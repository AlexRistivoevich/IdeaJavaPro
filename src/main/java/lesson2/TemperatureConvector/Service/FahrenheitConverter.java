package lesson2.TemperatureConvector.Service;

import lesson2.TemperatureConvector.Constans.TemperatureScale;
import org.springframework.stereotype.Component;

import static lesson2.TemperatureConvector.Constans.TemperatureConstants.*;


@Component
public class FahrenheitConverter implements TemperatureConverter{
    @Override
    public TemperatureScale getScale() {
        return TemperatureScale.FAHRENHEIT;
    }

    @Override
    public double convertTo(TemperatureScale targetScale, double value) {
        return switch (targetScale) {
            case KELVIN -> ( value + FAHRENHEIT_KELVIN_OFFSET) * RATIO_5_9;
            case CELSIUS -> (value - FAHRENHEIT_OFFSET) * RATIO_5_9;
            case FAHRENHEIT -> value;
        };
    }
}
