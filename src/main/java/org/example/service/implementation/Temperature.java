package org.example.service.implementation;

import lombok.Data;
import org.example.enums.MetricUnit;
import org.example.enums.TemperatureUnits;
import org.example.service.Metric;

@Data
public class Temperature implements Metric<Temperature> {
    private final TemperatureUnits unit;
    private final double value;

    @Override
    public Temperature convert(MetricUnit toUnit) {

        if (this.getUnit() == toUnit) {
            return new Temperature((TemperatureUnits) toUnit, this.getValue());
        }
        if (this.getUnit() == TemperatureUnits.CELSIUS && toUnit == TemperatureUnits.FAHRENHEIT) {
            return new Temperature((TemperatureUnits) toUnit, celsiusToFahrenheit(this.getValue()));
        }
        return new Temperature((TemperatureUnits) toUnit, fahrenheitToCelsius(this.getValue()));
    }

    @Override
    public Integer compare(Temperature comparedMetric) {
        return null;
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
