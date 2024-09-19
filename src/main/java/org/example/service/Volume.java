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
    public double add(Metric addend){
        return this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), VolumeUnits.LITER));
    }

    @Override
    public double subtract(Metric subtrahend){
        return this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), VolumeUnits.LITER));
    }

    @Override
    public Integer compare(Metric comparedVolume){
        Double value1 = this.getValue();
        Double value2 = comparedVolume.getValue() * getConversionFactor(comparedVolume.getUnit(), this.getUnit(), VolumeUnits.LITER);
        return value1.compareTo(value2);
    }
}
