package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAdvancedTest {

     
    // 1️ EQUALITY TESTS
     

    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    void testVolumeEquality() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(v1, v2);
    }

     
    // 2️ CONVERSION TESTS
     

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = l.convertTo(LengthUnit.INCHES);

        assertEquals(new Quantity<>(12.0, LengthUnit.INCHES), result);
    }

    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = w.convertTo(WeightUnit.GRAM);

        assertEquals(new Quantity<>(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    void testVolumeConversion() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(1000.0, VolumeUnit.MILLILITRE), result);
    }

     
    // 3️ ADDITION TESTS
     

    @Test
    void testLengthAdditionImplicit() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(new Quantity<>(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testWeightAdditionExplicit() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = w1.add(w2, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2000.0, WeightUnit.GRAM), result);
    }

    @Test
    void testVolumeAdditionExplicit() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.LITRE);

        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

     
    // 4️ SUBTRACTION TESTS
     

    @Test
    void testLengthSubtractionImplicit() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.subtract(l2);

        assertEquals(new Quantity<>(0.0, LengthUnit.FEET), result);
    }

    @Test
    void testLengthSubtractionExplicit() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.subtract(l2, LengthUnit.INCHES);

        assertEquals(new Quantity<>(6.0, LengthUnit.INCHES), result);
    }

     
    // 5️ DIVISION TESTS
     

    @Test
    void testDivisionSameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    void testDivisionDifferentUnits() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        double result = w1.divide(w2);

        assertEquals(1.0, result, 0.0001);
    }

     
    // 6️ EDGE CASES
     

    @Test
    void testZeroSubtraction() {
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.subtract(l2);

        assertEquals(new Quantity<>(0.0, LengthUnit.FEET), result);
    }

    @Test
    void testSameObjectEquality() {
        Quantity<LengthUnit> l = new Quantity<>(5.0, LengthUnit.FEET);

        assertEquals(l, l);
    }

    @Test
    void testNegativeResult() {
        Quantity<LengthUnit> l1 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> l2 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.subtract(l2);

        assertEquals(new Quantity<>(-6.0, LengthUnit.INCHES), result);
    }
}
