package org.example.service;

import lombok.EqualsAndHashCode;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;

@EqualsAndHashCode(callSuper = true)
public class Volume extends Metric{

    public Volume(VolumeUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public Volume convert(MetricUnit toUnit) {
        double value = this.getValue() * getConversionFactor(this.getUnit(), toUnit, VolumeUnits.LITER);
        return new Volume((VolumeUnits) toUnit, value);
    }

    @Override
    public Volume add(Metric addend){
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), VolumeUnits.LITER));
        return new Volume((VolumeUnits) this.getUnit(), value);
    }

    @Override
    public Volume subtract(Metric subtrahend){
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), VolumeUnits.LITER));
        return new Volume((VolumeUnits) this.getUnit(), value);
    }

    @Override
    public Integer compare(Metric comparedVolume){
        Double value1 = this.getValue();
        Double value2 = comparedVolume.getValue() * getConversionFactor(comparedVolume.getUnit(), this.getUnit(), VolumeUnits.LITER);
        return value1.compareTo(value2);
    }
}
