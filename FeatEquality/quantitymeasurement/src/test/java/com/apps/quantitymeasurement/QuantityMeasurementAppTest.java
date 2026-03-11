package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // UC1
    @Test
    void testFeetEquality() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(1, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    // UC2
    @Test
    void testFeetInchEquality() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    // UC3
    @Test
    void testDifferentLength() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    // UC4
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
    void testCentimeterToInchConversion() {

        assertEquals(1,
                Length.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES),
                0.0001);
    }

    @Test
    void testInvalidUnit() {

        assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1, null, LengthUnit.FEET));
    }

    // UC6
    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(2, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_WithZero() {

        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(5, LengthUnit.FEET), result);
    }

    // UC7
    @Test
    void testAddition_WithTargetUnit() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        assertEquals(new Length(0.6667, LengthUnit.YARDS), result);
    }

    // UC8
    @Test
    void testConvertToBaseUnit_InchesToFeet() {

        assertEquals(1,
                LengthUnit.INCHES.convertToBaseUnit(12),
                0.0001);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {

        assertEquals(12,
                LengthUnit.INCHES.convertFromBaseUnit(1),
                0.0001);
    }

    @Test
    void testConvertToMethod() {

        Length length = new Length(1, LengthUnit.FEET);

        Length result = length.convertTo(LengthUnit.INCHES);

        assertEquals(new Length(12, LengthUnit.INCHES), result);
    }

    @Test
    void testInvalidValue() {

        assertThrows(IllegalArgumentException.class, () ->
                new Length(Double.NaN, LengthUnit.FEET));
    }
 // ---------------- UC9 Weight Tests ----------------

    @Test
    void testWeightEquality_KilogramToGram() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testWeightEquality_Pound() {

        Weight w1 = new Weight(1, WeightUnit.POUND);
        Weight w2 = new Weight(1, WeightUnit.POUND);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testWeightConversion_KgToGram() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        Weight result = w.convertTo(WeightUnit.GRAM);

        assertEquals(new Weight(1000, WeightUnit.GRAM), result);
    }

    @Test
    void testWeightConversion_PoundToKilogram() {

        Weight w = new Weight(2.20462, WeightUnit.POUND);

        Weight result = w.convertTo(WeightUnit.KILOGRAM);

        assertEquals(new Weight(1, WeightUnit.KILOGRAM), result);
    }

    @Test
    void testWeightAddition_SameUnit() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(2, WeightUnit.KILOGRAM);

        Weight result = w1.add(w2);

        assertEquals(new Weight(3, WeightUnit.KILOGRAM), result);
    }

    @Test
    void testWeightAddition_CrossUnit() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        Weight result = w1.add(w2);

        assertEquals(new Weight(2, WeightUnit.KILOGRAM), result);
    }

    @Test
    void testWeightAddition_TargetUnit() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        Weight result = w1.add(w2, WeightUnit.GRAM);

        assertEquals(new Weight(2000, WeightUnit.GRAM), result);
    }

}
