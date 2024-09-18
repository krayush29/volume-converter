package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.LengthUnits;

import static org.example.repository.MetricRepository.conversionFactors;

public class Length {
    private final String unit;
    private final double value;

    public Length(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public double convert(String toUnit) {
        ImmutablePair<String, String> conversionKey = new ImmutablePair<>(unit, toUnit);
        Double conversionFactor = conversionFactors.get(conversionKey);
        if (conversionFactor == null){
            ImmutablePair<String, String> conversionToBaseKey = new ImmutablePair<>(unit, LengthUnits.METER.toString());
            ImmutablePair<String, String> conversionFromBaseKey = new ImmutablePair<>(LengthUnits.METER.toString(), toUnit);

            Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
            Double conversionFactorFromBase = conversionFactors.get(conversionFromBaseKey);

            if(conversionFactorToBase == null || conversionFactorFromBase == null)
                throw new IllegalArgumentException("Conversion from " + unit + " to " + toUnit + " is not supported.");

            return value * conversionFactorToBase * conversionFactorFromBase;
        }

        return value * conversionFactor;
    }
}
