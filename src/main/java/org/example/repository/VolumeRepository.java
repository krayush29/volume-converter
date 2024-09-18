package org.example.repository;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.example.enums.VolumeUnits;

import java.util.HashMap;
import java.util.Map;

public class VolumeRepository {
    public static final Map<ImmutablePair<VolumeUnits, VolumeUnits>, Double> conversionFactors = new HashMap<>();

    static {
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER,VolumeUnits.MILLILITER), 1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.CENTILITER), 100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.DECILITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.DECALITER), 0.1);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.LITER, VolumeUnits.KILOLITER), 0.001);

        conversionFactors.put(new ImmutablePair<>(VolumeUnits.MILLILITER, VolumeUnits.LITER), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.CENTILITER, VolumeUnits.LITER), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECILITER, VolumeUnits.LITER), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.DECALITER, VolumeUnits.LITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(VolumeUnits.KILOLITER, VolumeUnits.LITER), 1000.0);
    }
}
