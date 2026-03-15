package lesson2.TemperatureConvector.Service;

import lesson2.TemperatureConvector.Constans.TemperatureScale;
import org.springframework.stereotype.Component;

import static lesson2.TemperatureConvector.Constans.TemperatureConstants.*;


@Component
public class CelsiusConverter implements TemperatureConverter{
    @Override
    public TemperatureScale getScale() {
        return TemperatureScale.CELSIUS;
    }

    @Override
    public double convertTo(TemperatureScale targetScale, double value) {
        return switch (targetScale) {
            case KELVIN -> value + KELVIN_OFFSET;
            case CELSIUS -> value;
            case FAHRENHEIT -> (value * (RATIO_9_5)) + FAHRENHEIT_OFFSET;
        };
    }
}
