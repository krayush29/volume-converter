package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;

public interface Metric<T extends Metric<T,U>, U extends MetricUnit> {
    T convert(@NonNull U toUnit);

    Integer compare(@NonNull T comparedMetric);
}
