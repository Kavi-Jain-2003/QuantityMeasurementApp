package com.apps.quantitymeasurement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

	  @Test
	    void testEquality_FeetToFeet_SameValue() {
	        Length l1 = new Length(1.0, LengthUnit.FEET);
	        Length l2 = new Length(1.0, LengthUnit.FEET);

	        assertTrue(l1.equals(l2));
	    }
	  @Test
	    void givenYardAndFeetEquivalent_shouldReturnTrue() {
	        Length yard = new Length(1.0, LengthUnit.YARDS);
	        Length feet = new Length(3.0, LengthUnit.FEET);

	        assertTrue(yard.equals(feet));
	    }

	    // Cross-unit: Yard ↔ Inches
	    @Test
	    void givenYardAndInchesEquivalent_shouldReturnTrue() {
	        Length yard = new Length(1.0, LengthUnit.YARDS);
	        Length inch = new Length(36.0, LengthUnit.INCH);

	        assertTrue(yard.equals(inch));
	    }

	    // Cross-unit: Centimeter ↔ Inches
	    @Test
	    void givenCmAndInchesEquivalent_shouldReturnTrue() {
	        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);
	        Length inch = new Length(12.0, LengthUnit.INCH);

	        assertTrue(cm.equals(inch));
	    }

	    // Cross-unit inequality
	    @Test
	    void givenDifferentLengths_shouldReturnFalse() {
	        Length yard = new Length(1.0, LengthUnit.YARDS);
	        Length feet = new Length(2.0, LengthUnit.FEET);

	        assertFalse(yard.equals(feet));
	    }
	    
}