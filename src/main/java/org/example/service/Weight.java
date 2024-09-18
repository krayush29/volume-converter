package org.example.service;

import org.example.enums.MetricUnit;
import org.example.enums.WeightUnits;

public class Weight extends Metric{

    private final WeightUnits unit;
    private final double value;

    public Weight(WeightUnits unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public double convert(MetricUnit toUnit) {
        return value * getConversionFactor(unit, toUnit, WeightUnits.GRAM);
    }
}
