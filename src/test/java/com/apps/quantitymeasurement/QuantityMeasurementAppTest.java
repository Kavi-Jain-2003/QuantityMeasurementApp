package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // ---------------- LENGTH TESTS ----------------

    @Test
    void testLengthEquality_FeetToFeet() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(1, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testLengthEquality_FeetToInch() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> l = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> result = l.convertTo(LengthUnit.INCHES);

        assertEquals(12, result.getValue(), 0.0001);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(w1.equals(w2));
    }

    @Test
    void testWeightConversion() {

        Quantity<WeightUnit> w = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = w.convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), 0.001);
    }

    @Test
    void testWeightAddition() {

        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = w1.add(w2);

        assertEquals(new Quantity<>(2, WeightUnit.KILOGRAM), result);
    }

    // ---------------- VOLUME TESTS (UC11) ----------------

    @Test
    void testEquality_LitreToLitre_SameValue() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testEquality_LitreToMillilitre() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testEquality_GallonToLitre() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000, result.getValue(), 0.001);
    }

//    @Test
//    void testConversion_GallonToLitre() {
//
//        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.GALLON);
//
//        Quantity<VolumeUnit> result = v.convertTo(VolumeUnit.LITRE);
//
//        assertEquals(3.78541, result.getValue(), 0.0001);
//    }
//
    @Test
    void testAddition_LitrePlusMillilitre() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2);

        assertEquals(new Quantity<>(2.0, VolumeUnit.LITRE), result);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                v1.add(v2, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(2000.0, VolumeUnit.MILLILITRE), result);
    }

    // ---------------- CATEGORY SAFETY ----------------

    @Test
    void testVolumeVsLength_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }

    @Test
    void testVolumeVsWeight_Incompatible() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(volume.equals(weight));
    }
}
