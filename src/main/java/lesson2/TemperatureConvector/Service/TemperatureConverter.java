package lesson2.TemperatureConvector.Service;

import lesson2.TemperatureConvector.Constans.TemperatureScale;

public interface TemperatureConverter {
    TemperatureScale getScale();

    double convertTo(TemperatureScale targetScale, double value);
}
