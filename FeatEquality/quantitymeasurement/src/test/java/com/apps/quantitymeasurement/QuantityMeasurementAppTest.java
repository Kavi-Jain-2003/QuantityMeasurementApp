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
    void testAddition_CrossUnit_InchPlusFeet() {

        Length l1 = new Length(12, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(24, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_WithZero() {

        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(0, LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(new Length(5, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NegativeValues() {

        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(-2, LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(new Length(3, LengthUnit.FEET), result);
    }

    // 1. Feet + Inches → FEET
    @Test
    void givenFeetAndInches_whenTargetFeet_shouldReturnFeet() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = Length.add(l1, l2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.001);
    }

    // 2. Feet + Inches → INCHES
    @Test
    void givenFeetAndInches_whenTargetInches_shouldReturnInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = Length.add(l1, l2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.001);
    }

    // 3. Feet + Inches → YARDS
    @Test
    void givenFeetAndInches_whenTargetYards_shouldReturnYards() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = Length.add(l1, l2, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), 0.01);
    }

    // 4. Feet + Inches → CENTIMETERS
    @Test
    void givenFeetAndInches_whenTargetCm_shouldReturnCentimeters() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = Length.add(l1, l2, LengthUnit.CENTIMETERS);

        assertEquals(60.96, result.getValue(), 0.01);
    }

    // 5. Yards + Feet → FEET
    @Test
    void givenYardAndFeet_whenTargetFeet_shouldReturnFeet() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        Length result = Length.add(l1, l2, LengthUnit.FEET);

        assertEquals(5.0, result.getValue(), 0.001);
    }

    // 6. Zero case
    @Test
    void givenZeroLength_shouldReturnSameValue() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.FEET);

        Length result = Length.add(l1, zero, LengthUnit.FEET);

        assertEquals(1.0, result.getValue(), 0.001);
    }

    // 7. Negative case
    @Test
    void givenNegativeLength_shouldReturnCorrectResult() {
        Length l1 = new Length(5.0, LengthUnit.FEET);
        Length l2 = new Length(-2.0, LengthUnit.FEET);

        Length result = Length.add(l1, l2, LengthUnit.FEET);

        assertEquals(3.0, result.getValue(), 0.001);
    }

    // 8. Null input
    @Test
    void givenNullLength_shouldThrowException() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> Length.add(l1, null, LengthUnit.FEET));
    }

    // 9. Null target unit
    @Test
    void givenNullTargetUnit_shouldThrowException() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> Length.add(l1, l2, null));
    }
}
