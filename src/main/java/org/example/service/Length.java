package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;

import static org.example.repository.MetricRepository.conversionFactors;

public class Length implements Metric{
    private final LengthUnits unit;
    private final double value;

    public Length(LengthUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        ImmutablePair<MetricUnit, MetricUnit> conversionToBaseKey = new ImmutablePair<>(unit, LengthUnits.METER);
        ImmutablePair<MetricUnit, MetricUnit> conversionToUnitKey = new ImmutablePair<>(LengthUnits.METER, toUnit);

        Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
        Double conversionFactorToUnit = conversionFactors.get(conversionToUnitKey);

        if(conversionFactorToBase == null || conversionFactorToUnit == null)
            throw new IllegalArgumentException("Conversion from " + unit + " to " + toUnit + " is not supported.");

        return value * conversionFactorToBase * conversionFactorToUnit;
    }
}
