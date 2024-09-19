package org.example.repository;

import org.example.enums.LengthUnits;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;
import org.example.enums.WeightUnits;

import java.util.HashMap;
import java.util.Map;

public class MetricRepository {
    public static final Map<MetricUnit, Map<MetricUnit, Double>> conversionFactors = new HashMap<>();
    public static final Map<MetricUnit, Double> volumeConversionFactors = new HashMap<>();
    public static final Map<MetricUnit, Double> lengthConversionFactors = new HashMap<>();
    public static final Map<MetricUnit, Double> weightConversionFactors = new HashMap<>();

    static {
        volumeConversionFactors.put(VolumeUnits.MILLILITER, 1000.0);
        volumeConversionFactors.put(VolumeUnits.CENTILITER, 100.0);
        volumeConversionFactors.put(VolumeUnits.DECILITER, 10.0);
        volumeConversionFactors.put(VolumeUnits.LITER, 1.0);
        volumeConversionFactors.put(VolumeUnits.DECALITER, 0.1);
        volumeConversionFactors.put(VolumeUnits.KILOLITER, 0.001);
        conversionFactors.put(VolumeUnits.LITER, volumeConversionFactors);

        lengthConversionFactors.put(LengthUnits.MILLIMETER, 1000.0);
        lengthConversionFactors.put(LengthUnits.CENTIMETER, 100.0);
        lengthConversionFactors.put(LengthUnits.DECIMETER, 10.0);
        lengthConversionFactors.put(LengthUnits.METER, 1.0);
        lengthConversionFactors.put(LengthUnits.DECAMETER, 0.1);
        lengthConversionFactors.put(LengthUnits.KILOMETER, 0.001);
        conversionFactors.put(LengthUnits.METER, lengthConversionFactors);

        weightConversionFactors.put(WeightUnits.MILLIGRAM, 1000.0);
        weightConversionFactors.put(WeightUnits.CENTIGRAM, 100.0);
        weightConversionFactors.put(WeightUnits.DECIGRAM, 10.0);
        weightConversionFactors.put(WeightUnits.GRAM, 1.0);
        weightConversionFactors.put(WeightUnits.DECAGRAM, 0.1);
        weightConversionFactors.put(WeightUnits.KILOGRAM, 0.001);
        conversionFactors.put(WeightUnits.GRAM, weightConversionFactors);
    }
}
