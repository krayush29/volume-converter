package org.example.service.implementation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.enums.WeightUnits;
import org.example.service.Addable;
import org.example.service.Metric;

@Data
@EqualsAndHashCode
public class Weight implements Metric<Weight, WeightUnits>, Addable<Weight> {

    private final WeightUnits unit;
    private final double value;

    @Override
    public Weight convert(WeightUnits toUnit) {
        double value = this.getValue() * getConversionFactor(this.getUnit(), toUnit);
        return new Weight(toUnit, value);
    }

    @Override
    public Weight add(Weight addend) {
        double value = this.getValue() + (addend.getValue() * getConversionFactor(addend.getUnit(), this.getUnit()));
        return new Weight(this.getUnit(), value);
    }

    @Override
    public Weight subtract(Weight subtrahend) {
        double value = this.getValue() - (subtrahend.getValue() * getConversionFactor(subtrahend.getUnit(), this.getUnit()));
        return new Weight(this.getUnit(), value);
    }

    @Override
    public Integer compare(Weight comparedWeight) {
        // TODO: Override equals and hashcode
        Double value1 = this.getValue();
        Double value2 = comparedWeight.getValue() * getConversionFactor(comparedWeight.getUnit(), this.getUnit());
        return value1.compareTo(value2);
    }

    private double getConversionFactor(WeightUnits fromUnit, WeightUnits toUnit) {
        double conversionFactorToBase = WeightUnits.valueOf(fromUnit.toString()).getValue();
        double conversionFactorToUnit = WeightUnits.valueOf(toUnit.toString()).getValue();

        return (1 / conversionFactorToBase) * conversionFactorToUnit;
    }
}
