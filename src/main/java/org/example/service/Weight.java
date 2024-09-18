package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.MetricUnit;
import org.example.enums.WeightUnits;

import static org.example.repository.MetricRepository.conversionFactors;

public class Weight implements Metric{

    private final WeightUnits unit;
    private final double value;

    public Weight(WeightUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        ImmutablePair<MetricUnit, MetricUnit> conversionKey = new ImmutablePair<>(unit, toUnit);
        Double conversionFactor = conversionFactors.get(conversionKey);
        if (conversionFactor == null){
            ImmutablePair<MetricUnit, MetricUnit> conversionToBaseKey = new ImmutablePair<>(unit, WeightUnits.GRAM);
            ImmutablePair<MetricUnit, MetricUnit> conversionFromBaseKey = new ImmutablePair<>(WeightUnits.GRAM, toUnit);

            Double conversionFactorToBase = conversionFactors.get(conversionToBaseKey);
            Double conversionFactorFromBase = conversionFactors.get(conversionFromBaseKey);

            if(conversionFactorToBase == null || conversionFactorFromBase == null)
                throw new IllegalArgumentException("Conversion from " + unit + " to " + toUnit + " is not supported.");

            return value * conversionFactorToBase * conversionFactorFromBase;
        }

        return value * conversionFactor;
    }
}
