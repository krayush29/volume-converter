package org.example.enums;

import lombok.Getter;

@Getter
public enum LengthUnits implements MetricUnit {
    METER(1.0), MILLIMETER(1000.0), CENTIMETER(100.0), DECIMETER(10.0), DECAMETER(0.1), KILOMETER(0.001);

    private final double value;

    LengthUnits(double value) {
        this.value = value;
    }
}
