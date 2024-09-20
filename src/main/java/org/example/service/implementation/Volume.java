package org.example.service.implementation;

import lombok.Data;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;
import org.example.service.Addable;
import org.example.service.Metric;

@Data
public class Volume implements Metric<Volume>, Addable<Volume> {
    private final VolumeUnits unit;
    private final double value;

    @Override
    public Volume convert(MetricUnit toUnit) {
        if (!(toUnit instanceof VolumeUnits)) {
            throw new IllegalArgumentException("Cannot convert " + toUnit.getClass() + " to " + unit.getClass());
        }

        double value = this.getValue() * getConversionFactor(this.getUnit(), (VolumeUnits) toUnit);
        return new Volume((VolumeUnits) toUnit, value);
    }

    @Override
    public Volume add(Volume addend) {
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit()));
        return new Volume(this.getUnit(), value);
    }

    @Override
    public Volume subtract(Volume subtrahend) {
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit()));
        return new Volume(this.getUnit(), value);
    }

    @Override
    public Integer compare(Volume comparedVolume) {
        Double value1 = this.getValue();
        Double value2 = comparedVolume.getValue() * getConversionFactor(comparedVolume.getUnit(), this.getUnit());
        return value1.compareTo(value2);
    }

    private double getConversionFactor(VolumeUnits fromUnit, VolumeUnits toUnit) {
        double conversionFactorToBase = VolumeUnits.valueOf(fromUnit.toString()).getValue();
        double conversionFactorToUnit = VolumeUnits.valueOf(toUnit.toString()).getValue();

        return (1 / conversionFactorToBase) * conversionFactorToUnit;
    }
}
