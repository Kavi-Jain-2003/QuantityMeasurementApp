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

    // UC3
    @Test
    void testDifferentLength() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);

        assertFalse(l1.equals(l2));
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
}
