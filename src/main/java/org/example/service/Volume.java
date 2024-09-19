package org.example.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;

import static org.example.repository.MetricRepository.conversionFactors;

@EqualsAndHashCode(callSuper = true)
@Data
public class Volume extends Metric{

    private final VolumeUnits unit;
    private final double value;

    @Override
    public double convert(MetricUnit toUnit) {
        return value * getConversionFactor(unit, toUnit, VolumeUnits.LITER);
    }

    public double add(Volume addendVolume){
        return value + addendVolume.getValue() * (getConversionFactor(addendVolume.getUnit(), unit, VolumeUnits.LITER));
    }
}
