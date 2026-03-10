package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
	  @Test
	    void testEquality_FeetToFeet_SameValue() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);
	        Length l2 = new Length(1.0, LengthUnit.FEET);

	        assertTrue(l1.equals(l2));
	    }

	    @Test
	    void testEquality_InchToInch_SameValue() {
	        Length l1 = new Length(1.0, LengthUnit.INCHES);
	        Length l2 = new Length(1.0, LengthUnit.INCHES);

	        assertTrue(l1.equals(l2));
	    }

	    @Test
	    void testEquality_FeetToInch_EquivalentValue() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);
	        Length l2 = new Length(12.0, LengthUnit.INCHES);

	        assertTrue(l1.equals(l2));
	    }

	    @Test
	    void testEquality_InchToFeet_EquivalentValue() {
	        Length l1 = new Length(12.0, LengthUnit.INCHES);
	        Length l2 = new Length(1.0, LengthUnit.FEET);

	        assertTrue(l1.equals(l2));
	    }

	    @Test
	    void testEquality_FeetToFeet_DifferentValue() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);
	        Length l2 = new Length(2.0, LengthUnit.FEET);

	        assertFalse(l1.equals(l2));
	    }

	    @Test
	    void testEquality_InchToInch_DifferentValue() {
	        Length l1 = new Length(1.0, LengthUnit.INCHES);
	        Length l2 = new Length(2.0, LengthUnit.INCHES);

	        assertFalse(l1.equals(l2));
	    }

	    @Test
	    void testEquality_SameReference() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);

	        assertTrue(l1.equals(l1));
	    }

	    @Test
	    void testEquality_NullComparison() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);

	        assertFalse(l1.equals(null));
	    }

	    @Test
	    void testEquality_NullUnit() {
	        assertThrows(NullPointerException.class, () -> {
	            new Length(1.0, null);
	        });
	    }

	    @Test
	    void testEquality_InvalidUnit() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            LengthUnit.valueOf("INVALID");
	        });
	    }
	    
}
