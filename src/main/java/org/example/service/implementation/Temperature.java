package org.example.service.implementation;

import lombok.Data;
import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;
import org.example.enums.TemperatureUnits;
import org.example.service.Metric;

@Data
public class Temperature implements Metric<Temperature> {
    private final TemperatureUnits unit;
    private final double value;

    @Override
    public Temperature convert(MetricUnit toUnit) {
        if (!(toUnit instanceof TemperatureUnits)) {
            throw new IllegalArgumentException("Cannot convert " + toUnit.getClass() + " to " + unit.getClass());
        }
        double value = calculateValue(this.getValue(), this.getUnit(), (TemperatureUnits) toUnit);
        return new Temperature((TemperatureUnits) toUnit, value);
    }

    @Override
    public Integer compare(Temperature comparedMetric) {
        // TODO: Override equals and hashcode
        Double value1 = this.getValue();
        Double value2 = calculateValue(comparedMetric.getValue(), comparedMetric.getUnit(), this.getUnit());
        return value1.compareTo(value2);
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double calculateValue(double value, TemperatureUnits fromUnit, TemperatureUnits toUnit) {
        if (fromUnit == toUnit) {
            return value;
        }
        if (fromUnit == TemperatureUnits.CELSIUS && toUnit == TemperatureUnits.FAHRENHEIT) {
            return celsiusToFahrenheit(value);
        }
        return fahrenheitToCelsius(value);
    }
}
