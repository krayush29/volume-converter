package org.example.service;

import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;

public class Length extends Metric{
    public Length(LengthUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return this.getValue() * getConversionFactor(this.getUnit(), toUnit, LengthUnits.METER);
    }

    @Override
    public double add(Metric addend) {
        return this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), LengthUnits.METER));
    }

    @Override
    public double subtract(Metric subtrahend) {
        return this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), LengthUnits.METER));
    }

    @Override
    public Integer compare(Metric comparedLength) {
        Double value1 = this.getValue();
        Double value2 = comparedLength.getValue() * getConversionFactor(comparedLength.getUnit(), this.getUnit(), LengthUnits.METER);
        return value1.compareTo(value2);
    }
}
