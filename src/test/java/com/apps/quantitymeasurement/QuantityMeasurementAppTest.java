package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // LENGTH TESTS

    @Test
    void testLengthEquality_AllUnits() {
        assertEquals(
                new Quantity<>(1, LengthUnit.FEET),
                new Quantity<>(12, LengthUnit.INCH)
        );

        assertEquals(
                new Quantity<>(1, LengthUnit.YARDS),
                new Quantity<>(3, LengthUnit.FEET)
        );

        assertEquals(
                new Quantity<>(30.48, LengthUnit.CENTIMETER),
                new Quantity<>(1, LengthUnit.FEET)
        );
    }

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> f = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(12, LengthUnit.INCH),
                f.convertTo(LengthUnit.INCH)
        );

        assertEquals(
                new Quantity<>(30.48, LengthUnit.CENTIMETER),
                f.convertTo(LengthUnit.CENTIMETER)
        );
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> f = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> i = new Quantity<>(12, LengthUnit.INCH);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), f.add(i));
        assertEquals(new Quantity<>(24, LengthUnit.INCH), f.add(i, LengthUnit.INCH));
    }

    @Test
    void testLengthSubtraction() {
        Quantity<LengthUnit> f = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(6, LengthUnit.INCH),
                f.subtract(new Quantity<>(6, LengthUnit.INCH), LengthUnit.INCH)
        );
    }

    @Test
    void testLengthDivision() {
        Quantity<LengthUnit> y = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> f = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(3.0, y.divide(f), 0.001);
    }
    
    // WEIGHT TESTS

    @Test
    void testWeightEquality_AllUnits() {
        assertEquals(
                new Quantity<>(1, WeightUnit.KILOGRAM),
                new Quantity<>(1000, WeightUnit.GRAM)
        );

        assertEquals(
                new Quantity<>(1, WeightUnit.KILOGRAM),
                new Quantity<>(2.20462, WeightUnit.POUND)
        );
    }

    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);

        assertEquals(
                new Quantity<>(1000, WeightUnit.GRAM),
                kg.convertTo(WeightUnit.GRAM)
        );
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2, WeightUnit.KILOGRAM), kg.add(g));
        assertEquals(new Quantity<>(2000, WeightUnit.GRAM), kg.add(g, WeightUnit.GRAM));
    }

    @Test
    void testWeightSubtraction() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);

        assertEquals(
                new Quantity<>(500, WeightUnit.GRAM),
                kg.subtract(new Quantity<>(500, WeightUnit.GRAM), WeightUnit.GRAM)
        );
    }

    @Test
    void testWeightDivision() {
        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(1.0, kg.divide(g), 0.001);
    }

    // =======================
    // VOLUME TESTS
    // =======================

    @Test
    void testVolumeEquality_AllUnits() {
        assertEquals(
                new Quantity<>(1, VolumeUnit.LITRE),
                new Quantity<>(1000, VolumeUnit.MILLILITRE)
        );

        assertEquals(
                new Quantity<>(1, VolumeUnit.LITRE),
                new Quantity<>(0.264172, VolumeUnit.GALLON)
        );
    }

    @Test
    void testVolumeConversion() {
        Quantity<VolumeUnit> l = new Quantity<>(1, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(1000, VolumeUnit.MILLILITRE),
                l.convertTo(VolumeUnit.MILLILITRE)
        );
    }

    @Test
    void testVolumeAddition() {
        Quantity<VolumeUnit> l = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertEquals(new Quantity<>(2, VolumeUnit.LITRE), l.add(ml));
        assertEquals(new Quantity<>(2000, VolumeUnit.MILLILITRE), l.add(ml, VolumeUnit.MILLILITRE));
    }

    @Test
    void testVolumeSubtraction() {
        Quantity<VolumeUnit> l = new Quantity<>(1, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(500, VolumeUnit.MILLILITRE),
                l.subtract(new Quantity<>(500, VolumeUnit.MILLILITRE), VolumeUnit.MILLILITRE)
        );
    }

    @Test
    void testVolumeDivision() {
        Quantity<VolumeUnit> l = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertEquals(1.0, l.divide(ml), 0.001);
    }

    // =======================
    // EDGE CASES
    // =======================

    @Test
    void testZeroValues() {
        Quantity<LengthUnit> l = new Quantity<>(0, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(0, LengthUnit.INCH),
                l.convertTo(LengthUnit.INCH)
        );
    }

    @Test
    void testNegativeResult() {
        Quantity<LengthUnit> l1 = new Quantity<>(6, LengthUnit.INCH);
        Quantity<LengthUnit> l2 = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(-6, LengthUnit.INCH),
                l1.subtract(l2)
        );
    }

    @Test
    void testSameObject() {
        Quantity<WeightUnit> w = new Quantity<>(5, WeightUnit.KILOGRAM);

        assertEquals(w, w);
    }
}
