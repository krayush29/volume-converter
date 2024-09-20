package org.example.service;

import org.example.enums.TemperatureUnits;
import org.example.service.implementation.Temperature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureTest {

    // Convert 32 celsius to 89.6 fahrenheit
    @Test
    public void test32CelsiusToFahrenheit() {
        double celsius = 32.0;
        Temperature temperature = new Temperature(TemperatureUnits.CELSIUS, celsius);

        Temperature actualOutput = temperature.convert(TemperatureUnits.FAHRENHEIT);
        Temperature expectedOutput = new Temperature(TemperatureUnits.FAHRENHEIT, 89.6);

        assertEquals(expectedOutput, actualOutput);
    }

    // Convert 89.6 degree fahrenheit to 32 degree celsius
    @Test
    public void test89FahrenheitTo32Celsius() {
        double fahrenheit = 89.6;
        Temperature temperature = new Temperature(TemperatureUnits.FAHRENHEIT, fahrenheit);

        Temperature actualOutput = temperature.convert(TemperatureUnits.CELSIUS);
        Temperature expectedOutput = new Temperature(TemperatureUnits.CELSIUS, 32.0);

        assertEquals(expectedOutput, actualOutput);
    }
}