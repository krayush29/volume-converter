package org.example.service;

import org.example.enums.VolumeUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VolumeConvertorTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5LiterToMilliliter() {
        double liters = 5.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.LITER, VolumeUnits.MILLILITER, liters);

        double expectedOutput = 5000.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test7LiterToCentiliter() {
        double liters = 7.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.LITER, VolumeUnits.CENTILITER, liters);

        double expectedOutput = 700.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test23LiterToDeciliter() {
        double liters = 23.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.LITER, VolumeUnits.DECILITER, liters);

        double expectedOutput = 230.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToDecaliter() {
        double liters = 1.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.LITER, VolumeUnits.DECALITER, liters);

        double expectedOutput = 0.1;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToKiloliter() {
        double liters = 1.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.LITER, VolumeUnits.KILOLITER, liters);
        double expectedOutput = 0.001;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToLiter() {
        double milliliters = 1000.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.MILLILITER, VolumeUnits.LITER, milliliters);

        double expectedOutput = 1.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToDeciliter() {
        double milliliters = 23.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.MILLILITER, VolumeUnits.DECILITER, milliliters);

        double expectedOutput = 0.23;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToMilliliter() {
        double milliliters = 23.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.MILLILITER, VolumeUnits.MILLILITER, milliliters);

        double expectedOutput = 23.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDeciliterToMilliliter() {
        double deciliter = 45.0;
        VolumeConvertor volumeConvertor = new VolumeConvertor(VolumeUnits.DECILITER, VolumeUnits.MILLILITER, deciliter);

        double expectedOutput = 4500.0;
        double actualOutput = volumeConvertor.convert();

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

//    @Test
//    public void testExceptionForInvalidConversion() {
//        double value = 1.0;
//        VolumeConvertor volumeConvertor = new VolumeConvertor("InvalidConversion", "InvalidConversion", value);
//
//        assertThrows(IllegalArgumentException.class, () -> {volumeConvertor.convert();});
//    }
}