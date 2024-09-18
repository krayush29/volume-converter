package org.example.service;

import org.example.enums.WeightUnits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5GramToMilligram() {
        double grams = 5.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);
        double expectedOutput = 5000.0;
        double actualOutput = weight.convert(WeightUnits.MILLIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test7GramToCentigram() {
        double grams = 7.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        double expectedOutput = 700.0;
        double actualOutput = weight.convert(WeightUnits.CENTIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void test23GramToDecigram() {
        double grams = 23.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        double expectedOutput = 230.0;
        double actualOutput = weight.convert(WeightUnits.DECIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testGramToDecagram() {
        double grams = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        double expectedOutput = 0.1;
        double actualOutput = weight.convert(WeightUnits.DECAGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testGramToKilogram() {
        double grams = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);
        double expectedOutput = 0.001;
        double actualOutput = weight.convert(WeightUnits.KILOGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilligramToGram() {
        double milligrams = 1000.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        double expectedOutput = 1.0;
        double actualOutput = weight.convert(WeightUnits.GRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilligramToDecigram() {
        double milligrams = 23.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        double expectedOutput = 0.23;
        double actualOutput = weight.convert(WeightUnits.DECIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testMilligramToMilligram() {
        double milligrams = 23.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        double expectedOutput = 23.0;
        double actualOutput = weight.convert(WeightUnits.MILLIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testDecigramToMilligram() {
        double decigrams = 45.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, decigrams);

        double expectedOutput = 4500.0;
        double actualOutput = weight.convert(WeightUnits.MILLIGRAM);

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}