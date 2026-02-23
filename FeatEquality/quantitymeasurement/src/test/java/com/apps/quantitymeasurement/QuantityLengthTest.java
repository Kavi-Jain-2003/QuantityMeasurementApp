package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityLengthTest {

    // uc1
    @Test
    void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    // uc2
    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    // uc3
    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null));
    }
    //uc4
    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARD);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(yard.equals(feet));
    }
    @Test
    void testEquality_CentimeterToCentimeter_SameValue() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CentimeterToInch_EquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength inch = new QuantityLength(0.393701, LengthUnit.INCH);
        assertTrue(cm.equals(inch));
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(cm.equals(feet));
    }
    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        QuantityLength yard =
                new QuantityLength(1.0, LengthUnit.YARD);

        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength inch =
                new QuantityLength(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }
 // -----------------------------
 // UC5 – Unit Conversion Tests
 // -----------------------------

 @Test
 void testConversion_FeetToInch() {
     double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
     assertEquals(12.0, result, 0.0001);
 }

 @Test
 void testConversion_InchToFeet() {
     double result = QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET);
     assertEquals(2.0, result, 0.0001);
 }

 @Test
 void testConversion_YardToFeet() {
     double result = QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.FEET);
     assertEquals(3.0, result, 0.0001);
 }

 @Test
 void testConversion_YardToInch() {
     double result = QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH);
     assertEquals(36.0, result, 0.0001);
 }

 @Test
 void testConversion_CentimeterToInch() {
     double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
     assertEquals(1.0, result, 0.0001);
 }

 @Test
 void testConversion_SameUnit() {
     double result = QuantityLength.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
     assertEquals(5.0, result, 0.0001);
 }

 @Test
 void testConversion_ZeroValue() {
     double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH);
     assertEquals(0.0, result, 0.0001);
 }

 @Test
 void testConversion_NegativeValue() {
     double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH);
     assertEquals(-12.0, result, 0.0001);
 }

 @Test
 void testConversion_NullUnit() {
     assertThrows(IllegalArgumentException.class,
             () -> QuantityLength.convert(1.0, null, LengthUnit.FEET));
 }




}
