package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.VolumeUnits;

import static org.example.repository.VolumeRepository.conversionFactors;


public class VolumeConvertor {

    private final VolumeUnits fromUnit;
    private final VolumeUnits toUnit;
    private final double value;

    public VolumeConvertor(VolumeUnits fromUnit, VolumeUnits toUnit, double value) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.value = value;
    }

    public double convert() {
        ImmutablePair<VolumeUnits, VolumeUnits> conversionKey = new ImmutablePair<>(fromUnit, toUnit);
        Double conversionFactor = conversionFactors.get(conversionKey);
        if (conversionFactor == null){
            ImmutablePair<VolumeUnits, VolumeUnits> conversionToBaseKey = new ImmutablePair<>(fromUnit, VolumeUnits.LITER);
            ImmutablePair<VolumeUnits, VolumeUnits> conversionFromBaseKey = new ImmutablePair<>(VolumeUnits.LITER, toUnit);

            Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
            Double conversionFactorFromBase = conversionFactors.get(conversionFromBaseKey);

            if(conversionFactorToBase == null || conversionFactorFromBase == null)
                throw new IllegalArgumentException("Conversion from " + fromUnit + " to " + toUnit + " is not supported.");

            return value * conversionFactorToBase * conversionFactorFromBase;
        }

        return value * conversionFactor;
    }
}
