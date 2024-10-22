package org.example.enums;

public enum TemperatureUnits implements MetricUnit {
    CELSIUS{
        public double toBase(double value) {
            return value;
        }

        public double fromBase(double value) {
            return value;
        }
    }, FAHRENHEIT{
        public double toBase(double value) {
            return (value - 32) * 5/9;
        }

        public double fromBase(double value) {
            return value * 9/5 + 32;
        }
    };
}
