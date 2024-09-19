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

    //Addition
    // should be able to add 1 gram and 1 milligram and get 1.001 gram
    @Test
    public void testAdd1GramTo1Milligram() {
        double valueInGram = 1.0;
        double valueInMilligram = 1.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = 1.001;
        double actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    // should be able to add 1 centigram adn 1 gram and get 101 centigram
    @Test
    public void testAdd1CentigramTo1Gram() {
        double valueInCentigram = 1.0;
        double valueInGram = 1.0;
        Weight weight = new Weight(WeightUnits.CENTIGRAM, valueInCentigram);

        double expectedOutput = 101;
        double actualOutput = weight.add(new Weight(WeightUnits.GRAM, valueInGram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testAdd5GramTo3000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 3000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = 8.0;
        double actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testAdd5DecigramTo70Milligram() {
        double valueInDecigram = 5.0;
        double valueInMilligram = 70.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, valueInDecigram);

        double expectedOutput = 5.7;
        double actualOutput = weight.add(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    // Subtract
    @Test
    public void testSubtract5GramTo3000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 3000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = 2.0;
        double actualOutput = weight.subtract(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testSubtract5DecigramTo70Milligram() {
        double valueInDecigram = 5.0;
        double valueInMilligram = 70.0;
        Weight weight = new Weight(WeightUnits.DECIGRAM, valueInDecigram);

        double expectedOutput = 4.3;
        double actualOutput = weight.subtract(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    // Compare
    @Test
    public void testCompare5GramTo5000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 5000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = 0;
        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5GramTo6000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 6000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = -1;
        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare5GramTo4000Milligram() {
        double valueInGram = 5.0;
        double valueInMilligram = 4000.0;
        Weight weight = new Weight(WeightUnits.GRAM, valueInGram);

        double expectedOutput = 1;
        Integer actualOutput = weight.compare(new Weight(WeightUnits.MILLIGRAM, valueInMilligram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }

    @Test
    public void testCompare1000CentigramTo1DecaGram() {
        double valueInCentigram = 1000.0;
        double valueInDecaGram = 1.0;
        Weight weight = new Weight(WeightUnits.CENTIGRAM, valueInCentigram);

        double expectedOutput = 0;
        Integer actualOutput = weight.compare(new Weight(WeightUnits.DECAGRAM, valueInDecaGram));

        assertEquals(expectedOutput, actualOutput, DELTA);
    }
}