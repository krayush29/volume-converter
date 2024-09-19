package org.example.service;

import lombok.EqualsAndHashCode;
import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;

@EqualsAndHashCode(callSuper = true)
public class Length extends Metric{
    public Length(LengthUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public Length convert(MetricUnit toUnit) {
        double value = this.getValue() * getConversionFactor(this.getUnit(), toUnit, LengthUnits.METER);
        return new Length((LengthUnits) toUnit, value);
    }

    @Override
    public Length add(Metric addend) {
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), LengthUnits.METER));
        return new Length((LengthUnits) this.getUnit(), value);
    }

    @Override
    public Length subtract(Metric subtrahend) {
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), LengthUnits.METER));
        return new Length((LengthUnits) this.getUnit(), value);
    }

    @Override
    public Integer compare(Metric comparedLength) {
        Double value1 = this.getValue();
        Double value2 = comparedLength.getValue() * getConversionFactor(comparedLength.getUnit(), this.getUnit(), LengthUnits.METER);
        return value1.compareTo(value2);
    }
}
