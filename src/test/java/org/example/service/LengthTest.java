package org.example.service;

import org.example.enums.LengthUnits;
import org.example.service.implementation.Length;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5MeterToMilliMeter() {
        double meters = 5.0;
        Length length = new Length(LengthUnits.METER, meters);

        Length actualOutput = length.convert(LengthUnits.MILLIMETER);
        Length expectedOutput = new Length(LengthUnits.MILLIMETER, 5000.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test7MeterToCentimeter() {
        double meters = 7.0;
        Length length = new Length(LengthUnits.METER, meters);

        Length actualOutput = length.convert(LengthUnits.CENTIMETER);
        Length expectedOutput = new Length(LengthUnits.CENTIMETER, 700.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test23MeterToDecimeter() {
        double meters = 23.0;
        Length length = new Length(LengthUnits.METER, meters);

        Length actualOutput = length.convert(LengthUnits.DECIMETER);
        Length expectedOutput = new Length(LengthUnits.DECIMETER, 230.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMeterToDecameter() {
        double meters = 1.0;
        Length length = new Length(LengthUnits.METER, meters);

        Length actualOutput = length.convert(LengthUnits.DECAMETER);
        Length expectedOutput = new Length(LengthUnits.DECAMETER, 0.1);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMeterToKilometer() {
        double meters = 1.0;
        Length length = new Length(LengthUnits.METER, meters);

        Length actualOutput = length.convert(LengthUnits.KILOMETER);
        Length expectedOutput = new Length(LengthUnits.KILOMETER, 0.001);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliMeterToMeter() {
        double millimeters = 1000.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        Length actualOutput = length.convert(LengthUnits.METER);
        Length expectedOutput = new Length(LengthUnits.METER, 1.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliMeterToDecimeter() {
        double millimeters = 23.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        Length actualOutput = length.convert(LengthUnits.DECIMETER);
        Length expectedOutput = new Length(LengthUnits.DECIMETER, 0.23);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliMeterToMilliMeter() {
        double millimeters = 23.0;
        Length length = new Length(LengthUnits.MILLIMETER, millimeters);

        Length actualOutput = length.convert(LengthUnits.MILLIMETER);
        Length expectedOutput = new Length(LengthUnits.MILLIMETER, 23.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecimeterToMilliMeter() {
        double decimeter = 45.0;
        Length length = new Length(LengthUnits.DECIMETER, decimeter);

        Length actualOutput = length.convert(LengthUnits.MILLIMETER);
        Length expectedOutput = new Length(LengthUnits.MILLIMETER, 4500.0);

        assertEquals(expectedOutput, actualOutput);
    }

    //Addition
    // should be able to add 1 meter and 1 millimeter and get 1.001 meter
    @Test
    public void testAdd1MeterTo1Millimeter() {
        double valueInMeter = 1.0;
        double valueInMillimeter = 1.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        Length actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));
        Length expectedOutput = new Length(LengthUnits.METER, 1.001);

        assertEquals(expectedOutput, actualOutput);
    }

    // should be able to add 1 centimeter adn 1 meter and get 101 centimeter
    @Test
    public void testAdd1CentimeterTo1Meter() {
        double valueInCentimeter = 1.0;
        double valueInMeter = 1.0;
        Length length = new Length(LengthUnits.CENTIMETER, valueInCentimeter);

        Length actualOutput = length.add(new Length(LengthUnits.METER, valueInMeter));
        Length expectedOutput = new Length(LengthUnits.CENTIMETER, 101);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5MeterTo3000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 3000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        Length actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));
        Length expectedOutput = new Length(LengthUnits.METER, 8.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5DecimeterTo70Millimeter() {
        double valueInDecimeter = 5.0;
        double valueInMillimeter = 70.0;
        Length length = new Length(LengthUnits.DECIMETER, valueInDecimeter);

        Length actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));
        Length expectedOutput = new Length(LengthUnits.DECIMETER, 5.7);

        assertEquals(expectedOutput, actualOutput);
    }

    // Subtract
    @Test
    public void testSubtract5MeterTo3000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 3000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        Length actualOutput = length.subtract(new Length(LengthUnits.MILLIMETER, valueInMillimeter));
        Length expectedOutput = new Length(LengthUnits.METER, 2.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSubtract5DecimeterTo70Millimeter() {
        double valueInDecimeter = 5.0;
        double valueInMillimeter = 70.0;
        Length length = new Length(LengthUnits.DECIMETER, valueInDecimeter);

        Length actualOutput = length.subtract(new Length(LengthUnits.MILLIMETER, valueInMillimeter));
        Length expectedOutput = new Length(LengthUnits.DECIMETER, 4.3);

        assertEquals(expectedOutput, actualOutput);
    }

    // Compare
    @Test
    public void testCompare5MeterTo5000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 5000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = 0;
        Integer actualOutput = length.compare(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5MeterTo6000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 6000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = -1;
        Integer actualOutput = length.compare(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5MeterTo4000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 4000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = 1;
        Integer actualOutput = length.compare(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare1000CentimeterTo1DecaMeter() {
        double valueInCentimeter = 1000.0;
        double valueInDecaMeter = 1.0;
        Length length = new Length(LengthUnits.CENTIMETER, valueInCentimeter);

        double expectedOutput = 0;
        Integer actualOutput = length.compare(new Length(LengthUnits.DECAMETER, valueInDecaMeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}