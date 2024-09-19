package org.example.service;

import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;


public class Volume extends Metric{

    public Volume(VolumeUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return this.getValue() * getConversionFactor(this.getUnit(), toUnit, VolumeUnits.LITER);
    }

    @Override
    public double add(Metric addendVolume){
        return this.getValue() + addendVolume.getValue() * (getConversionFactor(addendVolume.getUnit(), this.getUnit(), VolumeUnits.LITER));
    }
}
