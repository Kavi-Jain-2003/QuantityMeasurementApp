package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

	    /* ---------------- EQUALITY ---------------- */

	    @Test
	    void testEquality_FeetAndInches() {

	        Quantity<LengthUnit> q1 = new Quantity<>(12.0, LengthUnit.INCHES);
	        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);

	        assertEquals(q1, q2);
	    }

	    @Test
	    void testEquality_LitreAndMillilitre() {

	        Quantity<VolumeUnit> q1 = new Quantity<>(1.0, VolumeUnit.LITRE);
	        Quantity<VolumeUnit> q2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

	        assertEquals(q1, q2);
	    }

	    /* ---------------- ADDITION ---------------- */

	    @Test
	    void testAddition_SameUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

	        Quantity<LengthUnit> result = q1.add(q2);

	        assertEquals(new Quantity<>(10.0, LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_CrossUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

	        Quantity<LengthUnit> result = q1.add(q2);

	        assertEquals(new Quantity<>(5.5, LengthUnit.FEET), result);
	    }

	    @Test
	    void testAddition_ExplicitTargetUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

	        Quantity<LengthUnit> result = q1.add(q2, LengthUnit.INCHES);

	        assertEquals(new Quantity<>(66.0, LengthUnit.INCHES), result);
	    }

	    /* ---------------- SUBTRACTION ---------------- */

	    @Test
	    void testSubtraction_SameUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);

	        Quantity<LengthUnit> result = q1.subtract(q2);

	        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), result);
	    }

	    @Test
	    void testSubtraction_CrossUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

	        Quantity<LengthUnit> result = q1.subtract(q2);

	        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
	    }

	    @Test
	    void testSubtraction_ExplicitTargetUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

	        Quantity<LengthUnit> result = q1.subtract(q2, LengthUnit.INCHES);

	        assertEquals(new Quantity<>(114.0, LengthUnit.INCHES), result);
	    }

	    @Test
	    void testSubtraction_ResultingNegative() {

	        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

	        Quantity<LengthUnit> result = q1.subtract(q2);

	        assertEquals(new Quantity<>(-5.0, LengthUnit.FEET), result);
	    }

	    /* ---------------- DIVISION ---------------- */

	    @Test
	    void testDivision_SameUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

	        double result = q1.divide(q2);

	        assertEquals(5.0, result);
	    }

	    @Test
	    void testDivision_CrossUnit() {

	        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCHES);
	        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

	        double result = q1.divide(q2);

	        assertEquals(1.0, result);
	    }

	    @Test
	    void testDivision_RatioLessThanOne() {

	        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
	        Quantity<VolumeUnit> q2 = new Quantity<>(10.0, VolumeUnit.LITRE);

	        double result = q1.divide(q2);

	        assertEquals(0.5, result);
	    }

	    /* ---------------- ERROR CASES ---------------- */

	    @Test
	    void testSubtraction_NullOperand() {

	        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

	        assertThrows(IllegalArgumentException.class,
	                () -> q.subtract(null));
	    }

	    @Test
	    void testDivision_ByZero() {

	        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);

	        assertThrows(ArithmeticException.class,
	                () -> q1.divide(q2));
	    }

	    @Test
	    void testCrossCategoryOperation() {

	        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<WeightUnit> weight = new Quantity<>(5.0, WeightUnit.KILOGRAM);

	        assertThrows(IllegalArgumentException.class,
	                () -> length.subtract((Quantity) weight));
	    }
	}
