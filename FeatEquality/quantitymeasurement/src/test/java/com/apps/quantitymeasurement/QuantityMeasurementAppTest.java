package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    void testFeetInchEquality() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    void testYardAndFeetEquality() {
        assertTrue(new Length(1, LengthUnit.YARDS)
                .equals(new Length(3, LengthUnit.FEET)));
    }

    @Test
    void testCmAndInchesEquality() {
        assertTrue(new Length(30.48, LengthUnit.CENTIMETERS)
                .equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    void testFeetToInchesConversion() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertTrue(result.equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    void testInchesToFeetConversion() {
        double result = Length.convert(12.0, LengthUnit.INCHES, LengthUnit.FEET);

        assertEquals(1.0, result);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(1, null, LengthUnit.FEET));
    }
}
