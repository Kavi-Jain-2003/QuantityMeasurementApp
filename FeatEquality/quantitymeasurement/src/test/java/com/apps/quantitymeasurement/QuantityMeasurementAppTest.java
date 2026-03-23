package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        assertEquals(l1, l2);
    }

    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    void testInequality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(10, LengthUnit.INCHES);

        assertNotEquals(l1, l2);
    }

    @Test
    void testFeetToInchesConversion() {
        Quantity<LengthUnit> l = new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> result = l.convertTo(LengthUnit.INCHES);

        assertEquals(new Quantity<>(12, LengthUnit.INCHES), result);
    }


    @Test
    void testKgToGramConversion() {
        Quantity<WeightUnit> w = new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = w.convertTo(WeightUnit.GRAM);

        assertEquals(new Quantity<>(1000, WeightUnit.GRAM), result);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = w1.add(w2);

        assertEquals(new Quantity<>(2, WeightUnit.KILOGRAM), result);
    }

    
    @Test
    void testLengthAdditionInInches() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2, LengthUnit.INCHES);

        assertEquals(new Quantity<>(24, LengthUnit.INCHES), result);
    }

    @Test
    void testWeightAdditionInGrams() {
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        Quantity<WeightUnit> result = w1.add(w2, WeightUnit.GRAM);

        assertEquals(new Quantity<>(2000, WeightUnit.GRAM), result);
    }

    
    @Test
    void testZeroAddition() {
        Quantity<LengthUnit> l1 = new Quantity<>(0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = l1.add(l2);

        assertEquals(new Quantity<>(1, LengthUnit.FEET), result);
    }

    @Test
    void testSameObjectEquality() {
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);

        assertEquals(l1, l1);
    }
}
