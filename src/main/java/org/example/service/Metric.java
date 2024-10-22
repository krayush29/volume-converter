package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;
import org.example.enums.VolumeUnits;
import org.example.service.implementation.Volume;

public interface Metric<T extends MetricUnit> {

    default Metric<T> convert(@NonNull T toUnit){
        double value = toUnit.fromBase();
        return new Metric<T>(toUnit, value);
    }

    default Integer compare(@NonNull T comparedMetric){
        return null;
    }
}
