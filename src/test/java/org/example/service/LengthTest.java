package org.example.service;

import org.example.enums.LengthUnits;
import org.example.enums.VolumeUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5MeterToMilliMeter() {
        double meters = 5.0;
        Length length = new Length(LengthUnits.METER, meters);

        double expectedOutput = 5000.0;
        double actualOutput = length.convert(LengthUnits.MILLIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test7MeterToCentimeter() {
        double meters = 7.0;
        Length length = new Length( LengthUnits.METER, meters);

        double expectedOutput = 700.0;
        double actualOutput = length.convert(LengthUnits.CENTIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test23MeterToDecimeter() {
        double meters = 23.0;
        Length length = new Length(LengthUnits.METER, meters);

        double expectedOutput = 230.0;
        double actualOutput = length.convert(LengthUnits.DECIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMeterToDecameter() {
        double meters = 1.0;
        Length length = new Length( LengthUnits.METER, meters);

        double expectedOutput = 0.1;
        double actualOutput = length.convert(LengthUnits.DECAMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMeterToKilometer() {
        double meters = 1.0;
        Length length = new Length( LengthUnits.METER, meters);
        double expectedOutput = 0.001;
        double actualOutput = length.convert(LengthUnits.KILOMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliMeterToMeter() {
        double millimeters = 1000.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        double expectedOutput = 1.0;
        double actualOutput = length.convert(LengthUnits.METER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliMeterToDecimeter() {
        double millimeters = 23.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        double expectedOutput = 0.23;
        double actualOutput = length.convert(LengthUnits.DECIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliMeterToMilliMeter() {
        double millimeters = 23.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        double expectedOutput = 23.0;
        double actualOutput = length.convert(LengthUnits.MILLIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDecimeterToMilliMeter() {
        double decimeter = 45.0;
        Length length = new Length( LengthUnits.DECIMETER, decimeter);

        double expectedOutput = 4500.0;
        double actualOutput = length.convert(LengthUnits.MILLIMETER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}