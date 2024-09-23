package org.example.service;

import lombok.NonNull;
import org.example.enums.MetricUnit;

public interface Metric<T extends Metric<T>> {
    T convert(@NonNull MetricUnit toUnit);

    Integer compare(@NonNull T comparedMetric);
}
