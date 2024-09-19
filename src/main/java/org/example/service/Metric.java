package org.example.service;

import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.MetricUnit;

import static org.example.repository.MetricRepository.conversionFactors;

abstract class Metric {

    abstract double convert(MetricUnit toUnit);

    double getConversionFactor(MetricUnit fromUnit, MetricUnit toUnit, MetricUnit baseUnit){
        Double conversionFactorToBase = getConversionFactorValue(baseUnit, fromUnit);
        Double conversionFactorToUnit = getConversionFactorValue(baseUnit, toUnit);

        if(conversionFactorToBase == null || conversionFactorToUnit == null)
            throw new IllegalArgumentException("Conversion from " + fromUnit + " to " + toUnit + " is not supported.");

        return (1/conversionFactorToBase) * conversionFactorToUnit;
    }

    private Double getConversionFactorValue(MetricUnit fromUnit, MetricUnit toUnit){
        ImmutablePair<MetricUnit, MetricUnit> conversionKey = new ImmutablePair<>(fromUnit, toUnit);
        return conversionFactors.get(conversionKey);
    }
}
