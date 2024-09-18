package org.example.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;

import static org.example.repository.MetricRepository.conversionFactors;


public class Volume extends Metric{

    private final VolumeUnits unit;
    private final double value;

    public Volume(VolumeUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return value * getConversionFactor(unit, toUnit, VolumeUnits.LITER);
    }

    public double add(MetricUnit addendUnit){
        ImmutablePair<MetricUnit, MetricUnit> conversionKey = new ImmutablePair<>(addendUnit, unit);
        Double conversionFactor = conversionFactors.get(conversionKey);

        return value + (1.0 * conversionFactor);
    }
}
