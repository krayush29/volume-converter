package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.VolumeUnits;

import static org.example.repository.VolumeRepository.conversionFactors;


public class Volume {

    private final VolumeUnits unit;
    private final double value;

    public Volume(VolumeUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public double convert(VolumeUnits toUnit) {
        ImmutablePair<VolumeUnits, VolumeUnits> conversionKey = new ImmutablePair<>(unit, toUnit);
        Double conversionFactor = conversionFactors.get(conversionKey);
        if (conversionFactor == null){
            ImmutablePair<VolumeUnits, VolumeUnits> conversionToBaseKey = new ImmutablePair<>(unit, VolumeUnits.LITER);
            ImmutablePair<VolumeUnits, VolumeUnits> conversionFromBaseKey = new ImmutablePair<>(VolumeUnits.LITER, toUnit);

            Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
            Double conversionFactorFromBase = conversionFactors.get(conversionFromBaseKey);

            if(conversionFactorToBase == null || conversionFactorFromBase == null)
                throw new IllegalArgumentException("Conversion from " + unit + " to " + toUnit + " is not supported.");

            return value * conversionFactorToBase * conversionFactorFromBase;
        }

        return value * conversionFactor;
    }
}
