package org.example.service;

import org.example.enums.MetricUnit;
import org.example.enums.WeightUnits;

public class Weight extends Metric{

    public Weight(WeightUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return this.getValue() * getConversionFactor(this.getUnit(), toUnit, WeightUnits.GRAM);
    }

    @Override
    double add(Metric addendVolume) {
        return 0;
    }
}
