package org.example.service;

import org.example.enums.LengthUnits;
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

    //Addition
    // should be able to add 1 meter and 1 millimeter and get 1.001 meter
    @Test
    public void testAdd1MeterTo1Millimeter() {
        double valueInMeter = 1.0;
        double valueInMillimeter = 1.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = 1.001;
        double actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    // should be able to add 1 centimeter adn 1 meter and get 101 centimeter
    @Test
    public void testAdd1CentimeterTo1Meter() {
        double valueInCentimeter = 1.0;
        double valueInMeter = 1.0;
        Length length = new Length(LengthUnits.CENTIMETER, valueInCentimeter);

        double expectedOutput = 101;
        double actualOutput = length.add(new Length(LengthUnits.METER, valueInMeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testAdd5MeterTo3000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 3000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = 8.0;
        double actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testAdd5DecimeterTo70Millimeter() {
        double valueInDecimeter = 5.0;
        double valueInMillimeter = 70.0;
        Length length = new Length(LengthUnits.DECIMETER, valueInDecimeter);

        double expectedOutput = 5.7;
        double actualOutput = length.add(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    // Subtract
    @Test
    public void testSubtract5MeterTo3000Millimeter() {
        double valueInMeter = 5.0;
        double valueInMillimeter = 3000.0;
        Length length = new Length(LengthUnits.METER, valueInMeter);

        double expectedOutput = 2.0;
        double actualOutput = length.subtract(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testSubtract5DecimeterTo70Millimeter() {
        double valueInDecimeter = 5.0;
        double valueInMillimeter = 70.0;
        Length length = new Length(LengthUnits.DECIMETER, valueInDecimeter);

        double expectedOutput = 4.3;
        double actualOutput = length.subtract(new Length(LengthUnits.MILLIMETER, valueInMillimeter));

        assertEquals(expectedOutput, actualOutput, DELTA);
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