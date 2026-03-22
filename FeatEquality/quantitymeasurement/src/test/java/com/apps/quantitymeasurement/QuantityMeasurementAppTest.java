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

        Length result = Length.add(l1, l2, LengthUnit.YARDS);

        assertEquals(new Length(0.667, LengthUnit.YARDS), result);
    }

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1,
                LengthUnit.INCHES.toFeet(12),
                0.0001);
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(12,
                LengthUnit.INCHES.fromFeet(1),
                0.0001);
    }

    @Test
    void testConvertToMethod() {

        Length l = new Length(1, LengthUnit.FEET);

        Length result = l.convertTo(LengthUnit.INCHES);

        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }
 // Weight equality
    @Test
    void testEquality_KgToGram() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    // conversion
    @Test
    void testConversion_KgToPound() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        Weight result = w.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), 0.001);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    // addition
    @Test
    void testAddition_KgPlusGram() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        Weight result = w1.add(w2);

        assertEquals(new Weight(2, WeightUnit.KILOGRAM), result);
    }
}
