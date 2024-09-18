package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;

import static org.example.repository.MetricRepository.conversionFactors;


public class Volume implements Metric{

    private final VolumeUnits unit;
    private final double value;

    public Volume(VolumeUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        ImmutablePair<MetricUnit, MetricUnit> conversionToBaseKey = new ImmutablePair<>(unit, VolumeUnits.LITER);
        ImmutablePair<MetricUnit, MetricUnit> conversionToUnitKey = new ImmutablePair<>(VolumeUnits.LITER, toUnit);

        Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
        Double conversionFactorToUnit = conversionFactors.get(conversionToUnitKey);

        if(conversionFactorToBase == null || conversionFactorToUnit == null)
            throw new IllegalArgumentException("Conversion from " + unit + " to " + toUnit + " is not supported.");

        return value * conversionFactorToBase * conversionFactorToUnit;
    }
}
