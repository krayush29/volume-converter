package org.example.service;

import org.example.enums.MetricUnit;

public interface Metric {
    double convert(MetricUnit toUnit);
}
