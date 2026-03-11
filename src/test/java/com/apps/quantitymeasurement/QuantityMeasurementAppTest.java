package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------- LENGTH ----------

    @Test
    void testFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testFeetEqualsYards() {
        Quantity<LengthUnit> feet = new Quantity<>(3, LengthUnit.FEET);
        Quantity<LengthUnit> yard = new Quantity<>(1, LengthUnit.YARDS);

        assertEquals(feet, yard);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    @Test
    void testLengthSubtraction() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    @Test
    void testLengthDivision() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        assertEquals(5.0, q1.divide(q2));
    }

    // ---------- WEIGHT ----------

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2, WeightUnit.KILOGRAM), kg.add(gram));
    }

    // ---------- VOLUME ----------

    @Test
    void testVolumeAddition() {
        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(2, VolumeUnit.LITRE), litre.add(ml));
    }

    @Test
    void testVolumeSubtractionWithTarget() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = q1.subtract(q2, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(3000, VolumeUnit.MILLILITRE), result);
    }

    // ---------- TEMPERATURE EQUALITY ----------

    @Test
    void testCelsiusEqualsFahrenheit() {
        Quantity<TemperatureUnit> c = new Quantity<>(0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> f = new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        assertEquals(c, f);
    }

    @Test
    void testCelsiusEqualsKelvin() {
        Quantity<TemperatureUnit> c = new Quantity<>(0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> k = new Quantity<>(273.15, TemperatureUnit.KELVIN);

        assertEquals(c, k);
    }

    @Test
    void testMinusFortyEquality() {
        Quantity<TemperatureUnit> c = new Quantity<>(-40, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> f = new Quantity<>(-40, TemperatureUnit.FAHRENHEIT);

        assertEquals(c, f);
    }

    // ---------- TEMPERATURE CONVERSION ----------

    @Test
    void testCelsiusToFahrenheit() {
        Quantity<TemperatureUnit> c = new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                c.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212, result.getValue(), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        Quantity<TemperatureUnit> f =
                new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                f.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(new Quantity<>(0, TemperatureUnit.CELSIUS), result);
    }

    @Test
    void testCelsiusToKelvin() {
        Quantity<TemperatureUnit> c =
                new Quantity<>(0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                c.convertTo(TemperatureUnit.KELVIN);

        assertEquals(new Quantity<>(273.15, TemperatureUnit.KELVIN), result);
    }

    // ---------- UNSUPPORTED TEMPERATURE OPERATIONS ----------

    @Test
    void testTemperatureAddUnsupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    void testTemperatureSubtractUnsupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    void testTemperatureDivideUnsupported() {
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(50, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    // ---------- CROSS CATEGORY ----------

    @Test
    void testTemperatureVsLength() {
        Quantity<TemperatureUnit> temp =
                new Quantity<>(100, TemperatureUnit.CELSIUS);

        Quantity<LengthUnit> length =
                new Quantity<>(100, LengthUnit.FEET);

        assertNotEquals(temp, length);
    }
}
