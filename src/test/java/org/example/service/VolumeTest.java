package org.example.service;

import org.example.enums.VolumeUnits;
import org.example.enums.WeightUnits;
import org.example.service.implementation.Volume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VolumeTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5LiterToMilliliter() {
        double liters = 5.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        Volume actualOutput = volume.convert(VolumeUnits.MILLILITER);
        Volume expectedOutput = new Volume(VolumeUnits.MILLILITER, 5000.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test7LiterToCentiliter() {
        double liters = 7.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        Volume actualOutput = volume.convert(VolumeUnits.CENTILITER);
        Volume expectedOutput = new Volume(VolumeUnits.CENTILITER, 700.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test23LiterToDeciliter() {
        double liters = 23.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        Volume actualOutput = volume.convert(VolumeUnits.DECILITER);
        Volume expectedOutput = new Volume(VolumeUnits.DECILITER, 230.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLiterToDecaliter() {
        double liters = 1.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        Volume actualOutput = volume.convert(VolumeUnits.DECALITER);
        Volume expectedOutput = new Volume(VolumeUnits.DECALITER, 0.1);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLiterToKiloliter() {
        double liters = 1.0;
        Volume volume = new Volume(VolumeUnits.LITER, liters);

        Volume actualOutput = volume.convert(VolumeUnits.KILOLITER);
        Volume expectedOutput = new Volume(VolumeUnits.KILOLITER, 0.001);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliliterToLiter() {
        double milliliters = 1000.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        Volume actualOutput = volume.convert(VolumeUnits.LITER);
        Volume expectedOutput = new Volume(VolumeUnits.LITER, 1.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliliterToDeciliter() {
        double milliliters = 23.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        Volume actualOutput = volume.convert(VolumeUnits.DECILITER);
        Volume expectedOutput = new Volume(VolumeUnits.DECILITER, 0.23);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilliliterToMilliliter() {
        double milliliters = 23.0;
        Volume volume = new Volume(VolumeUnits.MILLILITER, milliliters);

        Volume actualOutput = volume.convert(VolumeUnits.MILLILITER);
        Volume expectedOutput = new Volume(VolumeUnits.MILLILITER, 23.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDeciliterToMilliliter() {
        double deciliter = 45.0;
        Volume volume = new Volume(VolumeUnits.DECILITER, deciliter);

        Volume expectedOutput = new Volume(VolumeUnits.MILLILITER, 4500.0);
        Volume actualOutput = volume.convert(VolumeUnits.MILLILITER);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExceptionDeciliterToMilliGram() {
        double deciliter = 45.0;
        Volume volume = new Volume(VolumeUnits.DECILITER, deciliter);

        assertThrows(IllegalArgumentException.class, ()-> {volume.convert(WeightUnits.MILLIGRAM);});
    }

    //Addition
    // should be able to add 1 litre and 1 mililitre and get 1.001 litre
    @Test
    public void testAdd1LiterTo1Milliliter() {
        double valueInLiter = 1.0;
        double valueInMilliliter = 1.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Volume actualOutput = volume.add(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        Volume expectedOutput = new Volume(VolumeUnits.LITER, 1.001);

        assertEquals(expectedOutput, actualOutput);
    }

    // should be able to add 1 centilitre adn 1 litre and get 101 centilitre
    @Test
    public void testAdd1CentiliterTo1Liter() {
        double valueInCentiliter = 1.0;
        double valueInLiter = 1.0;
        Volume volume = new Volume(VolumeUnits.CENTILITER, valueInCentiliter);

        Volume actualOutput = volume.add(new Volume(VolumeUnits.LITER, valueInLiter));
        Volume expectedOutput = new Volume(VolumeUnits.CENTILITER, 101);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5LiterTo3000Milliliter() {
        double valueInLiter = 5.0;
        double valueInMilliliter = 3000.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Volume actualOutput = volume.add(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        Volume expectedOutput = new Volume(VolumeUnits.LITER, 8.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5DeciliterTo70Milliliter() {
        double valueInDeciliter = 5.0;
        double valueInMilliliter = 70.0;
        Volume volume = new Volume(VolumeUnits.DECILITER, valueInDeciliter);

        Volume actualOutput = volume.add(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        Volume expectedOutput = new Volume(VolumeUnits.DECILITER, 5.7);

        assertEquals(expectedOutput, actualOutput);
    }

    // Subtract
    @Test
    public void testSubtract5LiterTo3000Milliliter() {
        double valueInLiter = 5.0;
        double valueInMilliliter = 3000.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Volume actualOutput = volume.subtract(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        Volume expectedOutput = new Volume(VolumeUnits.LITER, 2.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSubtract5DeciliterTo70Milliliter() {
        double valueInDeciliter = 5.0;
        double valueInMilliliter = 70.0;
        Volume volume = new Volume(VolumeUnits.DECILITER, valueInDeciliter);

        Volume actualOutput = volume.subtract(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        Volume expectedOutput = new Volume(VolumeUnits.DECILITER, 4.3);

        assertEquals(expectedOutput, actualOutput);
    }

    // Compare
    @Test
    public void testCompare5LiterTo5000Milliliter() {
        double valueInLiter = 5.0;
        double valueInMilliliter = 5000.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Integer actualOutput = volume.compare(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        double expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5LiterTo6000Milliliter() {
        double valueInLiter = 5.0;
        double valueInMilliliter = 6000.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Integer actualOutput = volume.compare(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        double expectedOutput = -1;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5LiterTo4000Milliliter() {
        double valueInLiter = 5.0;
        double valueInMilliliter = 4000.0;
        Volume volume = new Volume(VolumeUnits.LITER, valueInLiter);

        Integer actualOutput = volume.compare(new Volume(VolumeUnits.MILLILITER, valueInMilliliter));
        double expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare1000CentiliterTo1DecaLiter() {
        double valueInCentiliter = 1000.0;
        double valueInDecaLiter = 1.0;
        Volume volume = new Volume(VolumeUnits.CENTILITER, valueInCentiliter);

        Integer actualOutput = volume.compare(new Volume(VolumeUnits.DECALITER, valueInDecaLiter));
        double expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}