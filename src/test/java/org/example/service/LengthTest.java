package org.example.service;

import org.example.enums.LengthUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    private final static Double DELTA = 0.001;

    @Test
    public void test5MeterToMilliMeter() {
        double meters = 5.0;
        Length length = new Length(LengthUnits.METER.toString(), meters);

        double expectedOutput = 5000.0;
        double actualOutput = length.convert(LengthUnits.MILLIMETER.toString());

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDeciMeterToMilliMeter() {
        double decimeter = 45.0;
        Length length = new Length(LengthUnits.DECIMETER.toString(), decimeter);

        double expectedOutput = 4500.0;
        double actualOutput = length.convert(LengthUnits.MILLIMETER.toString());

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

}