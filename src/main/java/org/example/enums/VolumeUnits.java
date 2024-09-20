package org.example.enums;

import lombok.Getter;

@Getter
public enum VolumeUnits implements MetricUnit {
    LITER(1.0), MILLILITER(1000.0), CENTILITER(100.0), DECILITER(10.0), DECALITER(0.1), KILOLITER(0.001);

    private final double value;

    VolumeUnits(double value) {
        this.value = value;
    }
}
