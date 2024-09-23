package org.example.service.implementation;

import lombok.Data;
import org.example.enums.LengthUnits;
import org.example.service.Addable;
import org.example.service.Metric;

@Data
public class Length implements Metric<Length, LengthUnits>, Addable<Length, LengthUnits> {

    private final LengthUnits unit;
    private final double value;

    @Override
    public Length convert(LengthUnits toUnit) {
        double value = this.getValue() * getConversionFactor(this.getUnit(), toUnit);
        return new Length( toUnit, value);
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
        // TODO: Override equals and hashcode
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
