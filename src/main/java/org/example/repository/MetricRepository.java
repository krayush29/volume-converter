package org.example.repository;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.LengthUnits;
import org.example.enums.VolumeUnits;

import java.util.HashMap;
import java.util.Map;

public class MetricRepository {
    public static final Map<ImmutablePair<String, String>, Double> conversionFactors = new HashMap<>();

    static {
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER.toString(),VolumeUnits.MILLILITER.toString()), 1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER.toString(), VolumeUnits.CENTILITER.toString()), 100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER.toString(), VolumeUnits.DECILITER.toString()), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER.toString(), VolumeUnits.DECALITER.toString()), 0.1);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER.toString(), VolumeUnits.KILOLITER.toString()), 0.001);

        conversionFactors.put(new ImmutablePair<>(VolumeUnits.MILLILITER.toString(), VolumeUnits.LITER.toString()), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.CENTILITER.toString(), VolumeUnits.LITER.toString()), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECILITER.toString(), VolumeUnits.LITER.toString()), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECALITER.toString(), VolumeUnits.LITER.toString()), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.KILOLITER.toString(), VolumeUnits.LITER.toString()), 1000.0);

       //Length conversions
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER.toString(), LengthUnits.MILLIMETER.toString()), 1000.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER.toString(), LengthUnits.CENTIMETER.toString()), 100.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER.toString(), LengthUnits.DECIMETER.toString()), 10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER.toString(), LengthUnits.DECAMETER.toString()), 0.1);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.METER.toString(), LengthUnits.KILOMETER.toString()), 0.001);

        conversionFactors.put(new ImmutablePair<>(LengthUnits.MILLIMETER.toString(), LengthUnits.METER.toString()), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.CENTIMETER.toString(), LengthUnits.METER.toString()), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.DECIMETER.toString(), LengthUnits.METER.toString()), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.DECAMETER.toString(), LengthUnits.METER.toString()), 10.0);
        conversionFactors.put(new ImmutablePair<>(LengthUnits.KILOMETER.toString(), LengthUnits.METER.toString()), 1000.0);
    }
}
