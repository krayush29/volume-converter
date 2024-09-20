package org.example.enums;

import lombok.Getter;

@Getter
public enum WeightUnits implements MetricUnit {
    GRAM(1.0), MILLIGRAM(1000.0), CENTIGRAM(100.0), DECIGRAM(10.0), DECAGRAM(0.1), KILOGRAM(0.001);

    private final double value;

    WeightUnits(double value) {
        this.value = value;
    }
}
