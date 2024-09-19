package org.example.service;

import lombok.EqualsAndHashCode;
import org.example.enums.MetricUnit;
import org.example.enums.WeightUnits;

@EqualsAndHashCode(callSuper = true)
public class Weight extends Metric{

    public Weight(WeightUnits unit, double value) {
        super(unit, value);
    }

    @Override
    public Weight convert(MetricUnit toUnit) {
        double value = this.getValue() * getConversionFactor(this.getUnit(), toUnit, WeightUnits.GRAM);
        return new Weight((WeightUnits) toUnit, value);
    }

    @Override
    public Weight add(Metric addend) {
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit(), WeightUnits.GRAM));
        return new Weight((WeightUnits) this.getUnit(), value);
    }

    @Override
    public Weight subtract(Metric subtrahend) {
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit(), WeightUnits.GRAM));
        return new Weight((WeightUnits) this.getUnit(), value);
    }

    @Override
    public Integer compare(Metric comparedWeight) {
        Double value1 = this.getValue();
        Double value2 = comparedWeight.getValue() * getConversionFactor(comparedWeight.getUnit(), this.getUnit(), WeightUnits.GRAM);
        return value1.compareTo(value2);
    }
}
