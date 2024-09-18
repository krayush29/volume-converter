package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;

import static org.example.constant.UnitConstant.LITER;
import static org.example.repository.VolumeRepository.conversionFactors;


public class VolumeConvertor {

    public double convert(String fromUnit, String toUnit, double value) {
        ImmutablePair<String, String> conversionKey = new ImmutablePair<>(fromUnit, toUnit);
        Double conversionFactor = conversionFactors.get(conversionKey);
        if (conversionFactor == null){
            ImmutablePair<String, String> conversionToBaseKey = new ImmutablePair<>(fromUnit, LITER);
            ImmutablePair<String, String> conversionFromBaseKey = new ImmutablePair<>(LITER, toUnit);

            Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
            Double conversionFactorFromBase = conversionFactors.get(conversionFromBaseKey);

            if(conversionFactorToBase == null || conversionFactorFromBase == null)
                throw new IllegalArgumentException("Conversion from " + fromUnit + " to " + toUnit + " is not supported.");

            return value * conversionFactorToBase * conversionFactorFromBase;
        }

        return value * conversionFactor;
    }
}
