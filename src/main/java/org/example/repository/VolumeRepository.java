package org.example.repository;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.HashMap;
import java.util.Map;

import static org.example.constant.UnitConstant.CENTILITER;
import static org.example.constant.UnitConstant.DECALITER;
import static org.example.constant.UnitConstant.DECILITER;
import static org.example.constant.UnitConstant.KILOLITER;
import static org.example.constant.UnitConstant.LITER;
import static org.example.constant.UnitConstant.MILLILITER;

public class VolumeRepository {
    public static final Map<ImmutablePair<String, String>, Double> conversionFactors = new HashMap<>();

    static {
        conversionFactors.put(new ImmutablePair<>(LITER, MILLILITER), 1000.0);
        conversionFactors.put(new ImmutablePair<>(LITER, CENTILITER), 100.0);
        conversionFactors.put(new ImmutablePair<>(LITER, DECILITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(LITER, DECALITER), 0.1);
        conversionFactors.put(new ImmutablePair<>(LITER, KILOLITER), 0.001);

        conversionFactors.put(new ImmutablePair<>(MILLILITER, LITER), 1/1000.0);
        conversionFactors.put(new ImmutablePair<>(CENTILITER, LITER), 1/100.0);
        conversionFactors.put(new ImmutablePair<>(DECILITER, LITER), 1/10.0);
        conversionFactors.put(new ImmutablePair<>(DECALITER, LITER), 10.0);
        conversionFactors.put(new ImmutablePair<>(KILOLITER, LITER), 1000.0);
    }
}
