package org.example.service;

import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;

public class Length extends Metric{
    private final LengthUnits unit;
    private final double value;

    public Length(LengthUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return value * getConversionFactor(unit, toUnit, LengthUnits.METER);
    }
}
