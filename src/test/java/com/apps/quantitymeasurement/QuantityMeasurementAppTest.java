package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantiyMeasurementAppTest{

    // ---------------- EQUALITY ----------------

    @Test
    void testCelsiusEqualsFahrenheit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        assertEquals(t1, t2);
    }

    // ---------------- CONVERSION ----------------

    @Test
    void testCelsiusToFahrenheit() {
        Quantity<TemperatureUnit> temp = new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                temp.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(new Quantity<>(212, TemperatureUnit.FAHRENHEIT), result);
    }
}
