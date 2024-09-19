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
    double add(Metric addendVolume) {
        return 0;
    }
}
