package org.example.service.implementation;

import lombok.Data;
import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;
import org.example.service.Addable;
import org.example.service.Metric;

@Data
public class Length implements Metric<Length>, Addable<Length> {

    private final LengthUnits unit;
    private final double value;

    @Override
    public Length convert(MetricUnit toUnit) {
        if (!(toUnit instanceof LengthUnits)) {
            throw new IllegalArgumentException("Cannot convert " + toUnit.getClass() + " to " + unit.getClass());
        }

        double value = this.getValue() * getConversionFactor(this.getUnit(), (LengthUnits) toUnit);
        return new Length((LengthUnits) toUnit, value);
    }

    @Override
    public Length add(Length addend) {
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit()));
        return new Length(this.getUnit(), value);
    }

    @Override
    public Length subtract(Length subtrahend) {
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit()));
        return new Length(this.getUnit(), value);
    }

    @Override
    public Integer compare(Length comparedLength) {
        Double value1 = this.getValue();
        Double value2 = comparedLength.getValue() * getConversionFactor(comparedLength.getUnit(), this.getUnit());
        return value1.compareTo(value2);
    }

    private double getConversionFactor(LengthUnits fromUnit, LengthUnits toUnit) {
        double conversionFactorToBase = LengthUnits.valueOf(fromUnit.toString()).getValue();
        double conversionFactorToUnit = LengthUnits.valueOf(toUnit.toString()).getValue();

        return (1 / conversionFactorToBase) * conversionFactorToUnit;
    }
}
