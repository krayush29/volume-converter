package org.example.enums;

import lombok.Getter;

@Getter
public enum VolumeUnits implements MetricUnit {
    LITER(1.0),
    MILLILITER(1000.0),
    CENTILITER(100.0), DECILITER(10.0), DECALITER(0.1), KILOLITER(0.001);


    private final double conversionFactor;

    VolumeUnits(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBase(double value) {
        return value/this.conversionFactor;
    }

    @Override
    public double fromBase(double value) {
        return value * this.conversionFactor;
    }
}
