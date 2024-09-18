package org.example.repository;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;
import org.example.enums.WeightUnits;

import java.util.HashMap;
import java.util.Map;

public class MetricRepository {
    public static final Map<ImmutablePair<MetricUnit, MetricUnit>, Double> conversionFactors = new HashMap<>();

    static {
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER,VolumeUnits.MILLILITER), 1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.CENTILITER), 100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.DECILITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER,VolumeUnits.LITER), 1.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.DECALITER), 0.1);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.KILOLITER), 0.001);

        conversionFactors.put(new ImmutablePair<>(VolumeUnits.MILLILITER, VolumeUnits.LITER), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.CENTILITER, VolumeUnits.LITER), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECILITER, VolumeUnits.LITER), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECALITER, VolumeUnits.LITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.KILOLITER, VolumeUnits.LITER), 1000.0);

       //Length conversions
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.MILLIMETER), 1000.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.CENTIMETER), 100.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.DECIMETER), 10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.METER), 1.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.DECAMETER), 0.1);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER, LengthUnits.KILOMETER), 0.001);

        conversionFactors.put(new ImmutablePair<>(LengthUnits.MILLIMETER, LengthUnits.METER), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.CENTIMETER, LengthUnits.METER), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.DECIMETER, LengthUnits.METER), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.DECAMETER, LengthUnits.METER), 10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.KILOMETER, LengthUnits.METER), 1000.0);

        //Weight Conversions
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.MILLIGRAM), 1000.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.CENTIGRAM), 100.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.DECIGRAM), 10.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.GRAM), 1.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.DECAGRAM), 0.1);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.GRAM, WeightUnits.KILOGRAM), 0.001);

        conversionFactors.put(new ImmutablePair<>(WeightUnits.MILLIGRAM, WeightUnits.GRAM), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.CENTIGRAM, WeightUnits.GRAM), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.DECIGRAM, WeightUnits.GRAM), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(WeightUnits.DECAGRAM, WeightUnits.GRAM), 10.0);
        conversionFactors.put(new ImmutablePair<>( WeightUnits.KILOGRAM, WeightUnits.GRAM), 1000.0);
    }
}
