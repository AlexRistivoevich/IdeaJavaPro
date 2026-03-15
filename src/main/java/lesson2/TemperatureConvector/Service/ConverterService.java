package lesson2.TemperatureConvector.Service;

import lesson2.TemperatureConvector.Constans.TemperatureScale;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ConverterService {
    private final Map<TemperatureScale, TemperatureConverter> convertersMap;

    public ConverterService (List<TemperatureConverter> converterList) {
        this.convertersMap = converterList.stream()
                .collect(Collectors.toMap(
                        TemperatureConverter::getScale,
                        Function.identity()
                ));
    }
    public double convertTemperature(TemperatureScale from, TemperatureScale to,double value ) {
        TemperatureConverter converter = convertersMap.get(from);
        return converter.convertTo(to, value);
    }
}
