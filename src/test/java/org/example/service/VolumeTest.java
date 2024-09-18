package org.example.service;

import org.example.enums.VolumeUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VolumeTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5LiterToMilliliter() {
        double liters = 5.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        double expectedOutput = 5000.0;
        double actualOutput = volume.convert(VolumeUnits.MILLILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test7LiterToCentiliter() {
        double liters = 7.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        double expectedOutput = 700.0;
        double actualOutput = volume.convert(VolumeUnits.CENTILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test23LiterToDeciliter() {
        double liters = 23.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        double expectedOutput = 230.0;
        double actualOutput = volume.convert(VolumeUnits.DECILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToDecaliter() {
        double liters = 1.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        double expectedOutput = 0.1;
        double actualOutput = volume.convert(VolumeUnits.DECALITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToKiloliter() {
        double liters = 1.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);
        double expectedOutput = 0.001;
        double actualOutput = volume.convert(VolumeUnits.KILOLITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToLiter() {
        double milliliters = 1000.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        double expectedOutput = 1.0;
        double actualOutput = volume.convert(VolumeUnits.LITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToDeciliter() {
        double milliliters = 23.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        double expectedOutput = 0.23;
        double actualOutput = volume.convert(VolumeUnits.DECILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToMilliliter() {
        double milliliters = 23.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        double expectedOutput = 23.0;
        double actualOutput = volume.convert(VolumeUnits.MILLILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDeciliterToMilliliter() {
        double deciliter = 45.0;
        Volume volume = new Volume(VolumeUnits.DECILITER, deciliter);

        double expectedOutput = 4500.0;
        double actualOutput = volume.convert(VolumeUnits.MILLILITER);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}