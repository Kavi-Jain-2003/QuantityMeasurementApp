package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(1, LengthUnit.FEET)));
    }

    @Test
    void testFeetInchesEquality() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    void testDifferentLength() {
        assertFalse(new Length(1, LengthUnit.FEET)
                .equals(new Length(2, LengthUnit.FEET)));
    }

    @Test
    void testFeetToInchesConversion() {
        assertEquals(12,
                Length.convert(1, LengthUnit.FEET, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    void testInchesToFeetConversion() {
        assertEquals(2,
                Length.convert(24, LengthUnit.INCHES, LengthUnit.FEET),
                0.0001);
    }

    @Test
    void testAddition() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(2, LengthUnit.FEET), result);
    }

    @Test
    void testAdditionWithTargetUnit() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(0.6667, LengthUnit.YARDS), result);
    }

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1,
                LengthUnit.INCHES.convertToBaseUnit(12),
                0.0001);
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(12,
                LengthUnit.INCHES.convertFromBaseUnit(1),
                0.0001);
    }

    @Test
    void testConvertToMethod() {

        Length l = new Length(1, LengthUnit.FEET);

        Length result = l.convertTo(LengthUnit.INCHES);

        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }
}
