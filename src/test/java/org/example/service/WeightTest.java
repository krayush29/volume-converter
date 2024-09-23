package org.example.service;

import org.example.enums.WeightUnits;
import org.example.service.implementation.Weight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightTest {

    private final static Double DELTA = 0.001;

    @Test
    public void test5GramToMilligram() {
        double grams = 5.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        Weight actualOutput = weight.convert(WeightUnits.MILLIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.MILLIGRAM, 5000.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test7GramToCentigram() {
        double grams = 7.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        Weight actualOutput = weight.convert(WeightUnits.CENTIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.CENTIGRAM, 700.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test23GramToDecigram() {
        double grams = 23.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        Weight actualOutput = weight.convert(WeightUnits.DECIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.DECIGRAM, 230.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGramToDecagram() {
        double grams = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        Weight actualOutput = weight.convert(WeightUnits.DECAGRAM);
        Weight expectedOutput = new Weight(WeightUnits.DECAGRAM, 0.1);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testGramToKilogram() {
        double grams = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, grams);

        Weight actualOutput = weight.convert(WeightUnits.KILOGRAM);
        Weight expectedOutput = new Weight(WeightUnits.KILOGRAM, 0.001);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilligramToGram() {
        double milligrams = 1000.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        Weight actualOutput = weight.convert(WeightUnits.GRAM);
        Weight expectedOutput = new Weight(WeightUnits.GRAM, 1.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilligramToDecigram() {
        double milligrams = 23.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        Weight actualOutput = weight.convert(WeightUnits.DECIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.DECIGRAM, 0.23);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMilligramToMilligram() {
        double milligrams = 23.0;
        Weight weight = new Weight(WeightUnits.MILLIGRAM, milligrams);

        Weight actualOutput = weight.convert(WeightUnits.MILLIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.MILLIGRAM, 23.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDecigramToMilligram() {
        double decigrams = 45.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, decigrams);

        Weight actualOutput = weight.convert(WeightUnits.MILLIGRAM);
        Weight expectedOutput = new Weight(WeightUnits.MILLIGRAM, 4500.0);

        assertEquals(expectedOutput, actualOutput);
    }

    // Addition
    // should be able to add 1 gram and 1 milligram and get 1.001 gram
    @Test
    public void testAdd1GramTo1Milligram() {
        double valueInGram = 1.0;
        double valueInMilligram = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Weight actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        Weight expectedOutput = new Weight(WeightUnits.GRAM, 1.001);

        assertEquals(expectedOutput, actualOutput);
    }

    // should be able to add 1 centigram adn 1 gram and get 101 centigram
    @Test
    public void testAdd1CentigramTo1Gram() {
        double valueInCentigram = 1.0;
        double valueInGram = 1.0;
        Weight weight = new Weight(WeightUnits.CENTIGRAM, valueInCentigram);

        Weight actualOutput = weight.add(new Weight(WeightUnits.GRAM, valueInGram));
        Weight expectedOutput = new Weight(WeightUnits.CENTIGRAM, 101);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5GramTo3000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 3000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Weight actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        Weight expectedOutput = new Weight(WeightUnits.GRAM, 8.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testAdd5DecigramTo70Milligram() {
        double valueInDecigram = 5.0;
        double valueInMilligram = 70.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, valueInDecigram);

        Weight actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        Weight expectedOutput = new Weight(WeightUnits.DECIGRAM, 5.7);

        assertEquals(expectedOutput, actualOutput);
    }

    // Subtract
    @Test
    public void testSubtract5GramTo3000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 3000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Weight actualOutput = weight.subtract(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        Weight expectedOutput = new Weight(WeightUnits.GRAM, 2.0);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSubtract5DecigramTo70Milligram() {
        double valueInDecigram = 5.0;
        double valueInMilligram = 70.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, valueInDecigram);

        Weight actualOutput = weight.subtract(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        Weight expectedOutput = new Weight(WeightUnits.DECIGRAM, 4.3);

        assertEquals(expectedOutput, actualOutput);
    }

    // Compare
    @Test
    public void testCompare5GramTo5000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 5000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        double expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5GramTo6000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 6000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        double expectedOutput = -1;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5GramTo4000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 4000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));
        double expectedOutput = 1;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare1000CentigramTo1DecaGram() {
        double valueInCentigram = 1000.0;
        double valueInDecaGram = 1.0;
        Weight weight = new Weight(WeightUnits.CENTIGRAM, valueInCentigram);

        Integer actualOutput = weight.compare(new Weight(WeightUnits.DECAGRAM, valueInDecaGram));
        double expectedOutput = 0;

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}