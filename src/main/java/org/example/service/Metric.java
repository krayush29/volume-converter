package org.example.service;

import lombok.Data;
import org.example.enums.MetricUnit;

import java.util.Map;

import static org.example.repository.MetricRepository.conversionFactors;

@Data
public abstract class Metric {

    private final MetricUnit unit;
    private final double value;

    abstract double convert(MetricUnit toUnit);
    abstract double add(Metric addendVolume);

    double getConversionFactor(MetricUnit fromUnit, MetricUnit toUnit, MetricUnit baseUnit){
        Double conversionFactorToBase = getConversionFactorValue(baseUnit, fromUnit);
        Double conversionFactorToUnit = getConversionFactorValue(baseUnit, toUnit);

        if(conversionFactorToBase == null || conversionFactorToUnit == null)
            throw new IllegalArgumentException("Conversion from " + fromUnit + " to " + toUnit + " is not supported.");

        return (1/conversionFactorToBase) * conversionFactorToUnit;
    }

    private Double getConversionFactorValue(MetricUnit fromUnit, MetricUnit toUnit){
        Map<MetricUnit, Double> baseMatricMap = conversionFactors.get(fromUnit);
        return baseMatricMap.get(toUnit);
    }
}
