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
    public double add(Metric addend) {
        return this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), WeightUnits.GRAM));
    }

    @Override
    public double subtract(Metric subtrahend) {
        return this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), WeightUnits.GRAM));
    }

    @Override
    public Integer compare(Metric comparedWeight) {
        Double value1 = this.getValue();
        Double value2 = comparedWeight.getValue() * getConversionFactor(comparedWeight.getUnit(), this.getUnit(), WeightUnits.GRAM);
        return value1.compareTo(value2);
    }
}
