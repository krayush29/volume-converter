package org.example.service;

import org.example.enums.MetricUnit;

public interface Metric<T extends Metric<T>> {
    T convert(MetricUnit toUnit);

    Integer compare(T comparedMetric);
}
