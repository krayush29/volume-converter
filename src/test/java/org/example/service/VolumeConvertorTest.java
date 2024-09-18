package org.example.service;

import org.junit.jupiter.api.Test;

import static org.example.constant.UnitConstant.CENTILITER;
import static org.example.constant.UnitConstant.DECALITER;
import static org.example.constant.UnitConstant.DECILITER;
import static org.example.constant.UnitConstant.KILOLITER;
import static org.example.constant.UnitConstant.LITER;
import static org.example.constant.UnitConstant.MILLILITER;
import static org.junit.jupiter.api.Assertions.*;

class VolumeConvertorTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5LiterToMilliliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double liters = 5.0;
        double expectedOutput = 5000.0;
        double actualOutput = volumeConvertor.convert("Ayush", MILLILITER, liters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test7LiterToCentiliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double liters = 7.0;
        double expectedOutput = 700.0;
        double actualOutput = volumeConvertor.convert(LITER, CENTILITER, liters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test23LiterToDeciliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double liters = 23.0;
        double expectedOutput = 230.0;
        double actualOutput = volumeConvertor.convert(LITER, DECILITER, liters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToDecaliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double liters = 1.0;
        double expectedOutput = 0.1;
        double actualOutput = volumeConvertor.convert(LITER, DECALITER, liters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testLiterToKiloliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double liters = 1.0;
        double expectedOutput = 0.001;
        double actualOutput = volumeConvertor.convert(LITER, KILOLITER, liters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToLiter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double milliliters = 1000.0;
        double expectedOutput = 1.0;
        double actualOutput = volumeConvertor.convert(MILLILITER, LITER, milliliters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToDeciliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double milliliters = 23.0;
        double expectedOutput = 0.23;
        double actualOutput = volumeConvertor.convert(MILLILITER, DECILITER, milliliters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilliliterToMilliliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double milliliters = 23.0;
        double expectedOutput = 23.0;
        double actualOutput = volumeConvertor.convert(MILLILITER, MILLILITER, milliliters);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDeciliterToMilliliter() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double deciliter = 45.0;
        double expectedOutput = 4500.0;
        double actualOutput = volumeConvertor.convert(DECILITER, MILLILITER, deciliter);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testExceptionForInvalidConversion() {
        VolumeConvertor volumeConvertor = new VolumeConvertor();
        double value = 1.0;
        assertThrows(IllegalArgumentException.class, () -> {volumeConvertor.convert("InvalidConversion", "InvalidConversion", value);});
    }
}