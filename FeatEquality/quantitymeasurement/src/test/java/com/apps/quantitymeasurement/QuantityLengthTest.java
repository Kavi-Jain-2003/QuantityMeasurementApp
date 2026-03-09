package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthUC8Test {

    private static final double EPSILON = 0.0001;

    // UC1–UC4: Equality tests
    @Test
    void testFeetEqualsInches() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inches), "1 Foot should equal 12 Inches");
    }

    @Test
    void testYardEqualsFeet() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet), "1 Yard should equal 3 Feet");
    }

    // UC5: Conversion tests
    @Test
    void testFeetToInchesConversion() {
        double inches = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(12.0, inches, EPSILON);
    }

    @Test
    void testYardsToFeetConversion() {
        double feet = QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET);
        assertEquals(9.0, feet, EPSILON);
    }

    @Test
    void testCentimeterToInchesConversion() {
        double inches = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
        assertEquals(1.0, inches, 1e-6); // floating point allowance
    }

    // UC6–UC7: Addition tests
    @Test
    void testAddDefaultUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength sum = a.add(b);

        assertEquals(2.0, sum.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, sum.getUnit());
    }

    @Test
    void testAddTargetUnits() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength sumInFeet = a.add(b, LengthUnit.FEET);
        QuantityLength sumInInches = a.add(b, LengthUnit.INCH);
        QuantityLength sumInYards = a.add(b, LengthUnit.YARD);

        assertEquals(2.0, sumInFeet.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, sumInFeet.getUnit());

        assertEquals(24.0, sumInInches.getValue(), EPSILON);
        assertEquals(LengthUnit.INCH, sumInInches.getUnit());

        assertEquals(0.6666666666666666, sumInYards.getValue(), EPSILON);
        assertEquals(LengthUnit.YARD, sumInYards.getUnit());
    }

    // UC8: Null / Invalid checks
    @Test
    void testNullUnitInConstructor() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null));
        assertEquals("Unit cannot be null", ex.getMessage());
    }

    @Test
    void testInvalidValue() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
        assertEquals("Invalid value", ex.getMessage());
    }

    @Test
    void testAddNullQuantity() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> a.add(null));
        assertEquals("Second operand cannot be null", ex.getMessage());
    }

    @Test
    void testAddNullTargetUnit() {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> a.add(b, null));
        assertEquals("Target unit cannot be null", ex.getMessage());
    }
}
