package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- UC1 ----------------

    @Test
    void testEquality_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(5, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    // ---------------- UC2 ----------------

    @Test
    void testEquality_FeetAndInches() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        assertEquals(q1, q2);
    }

    // ---------------- UC3 ----------------

    @Test
    void testEquality_FeetAndYards() {
        Quantity<LengthUnit> q1 = new Quantity<>(3, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(1, LengthUnit.YARDS);

        assertEquals(q1, q2);
    }

    // ---------------- UC4 ----------------

    @Test
    void testEquality_InchesAndCentimeters() {
        Quantity<LengthUnit> q1 = new Quantity<>(2, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(5.08, LengthUnit.CENTIMETERS);

        assertEquals(q1, q2);
    }

    // ---------------- UC5 ----------------

    @Test
    void testInequality_DifferentLengths() {
        Quantity<LengthUnit> q1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(3, LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    // ---------------- UC6 ----------------

    @Test
    void testAddition_Length_DefaultUnit() {

        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    // ---------------- UC7 ----------------

    @Test
    void testAddition_Length_TargetUnit() {

        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(q2, LengthUnit.INCHES);

        assertEquals(new Quantity<>(24, LengthUnit.INCHES), result);
    }

    // ---------------- UC8 ----------------

    @Test
    void testAddition_Weight() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = q1.add(q2);

        assertEquals(new Quantity<>(2, WeightUnit.KILOGRAM), result);
    }

    // ---------------- UC9 ----------------

    @Test
    void testAddition_Volume() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(1000, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(new Quantity<>(2, VolumeUnit.LITRE), result);
    }

    // ---------------- UC10 ----------------

    @Test
    void testSubtraction_Length() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(6, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    // ---------------- UC11 ----------------

    @Test
    void testSubtraction_TargetUnit() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(2, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                q1.subtract(q2, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(3000, VolumeUnit.MILLILITRE), result);
    }

    // ---------------- UC12 ----------------

    @Test
    void testDivision_SameUnit() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result);
    }

    @Test
    void testDivision_DifferentUnits() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(24, LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(1.0, result);
    }

    // ---------------- UC13 Validation ----------------

    @Test
    void testAdd_NullOperand_ThrowsException() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(null)
        );
    }

    @Test
    void testSubtract_CrossCategory_ThrowsException() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<WeightUnit> q2 =
                new Quantity<>(5, WeightUnit.KILOGRAM);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract((Quantity) q2)
        );
    }

    @Test
    void testDivide_ByZero_ThrowsException() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0, LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2)
        );
    }

}
