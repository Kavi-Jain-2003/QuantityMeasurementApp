package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthUC8Test {

//    private static final double EPSILON = 0.0001;
//
//    // UC1–UC4: Equality tests
//    @Test
//    void testFeetEqualsInches() {
//        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
//        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);
//
//        assertTrue(feet.equals(inches), "1 Foot should equal 12 Inches");
//    }
//
//    @Test
//    void testYardEqualsFeet() {
//        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
//        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
//
//        assertTrue(yard.equals(feet), "1 Yard should equal 3 Feet");
//    }
//
//    // UC5: Conversion tests
//    @Test
//    void testFeetToInchesConversion() {
//        double inches = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
//        assertEquals(12.0, inches, EPSILON);
//    }
//
//    @Test
//    void testYardsToFeetConversion() {
//        double feet = QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET);
//        assertEquals(9.0, feet, EPSILON);
//    }
//
//    @Test
//    void testCentimeterToInchesConversion() {
//        double inches = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
//        assertEquals(1.0, inches, 1e-6); // floating point allowance
//    }
//
//    // UC6–UC7: Addition tests
//    @Test
//    void testAddDefaultUnit() {
//        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
//        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
//
//        QuantityLength sum = a.add(b);
//
//        assertEquals(2.0, sum.getValue(), EPSILON);
//        assertEquals(LengthUnit.FEET, sum.getUnit());
//    }
//
//    @Test
//    void testAddTargetUnits() {
//        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
//        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
//
//        QuantityLength sumInFeet = a.add(b, LengthUnit.FEET);
//        QuantityLength sumInInches = a.add(b, LengthUnit.INCH);
//        QuantityLength sumInYards = a.add(b, LengthUnit.YARD);
//
//        assertEquals(2.0, sumInFeet.getValue(), EPSILON);
//        assertEquals(LengthUnit.FEET, sumInFeet.getUnit());
//
//        assertEquals(24.0, sumInInches.getValue(), EPSILON);
//        assertEquals(LengthUnit.INCH, sumInInches.getUnit());
//
//        assertEquals(0.6666666666666666, sumInYards.getValue(), EPSILON);
//        assertEquals(LengthUnit.YARD, sumInYards.getUnit());
//    }
//
	 private static final double LENGTH_EPSILON = 0.0001;

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

	    @Test
	    void testFeetToInchesConversion() {
	        double inches = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
	        assertEquals(12.0, inches, LENGTH_EPSILON);
	    }

	    @Test
	    void testCentimeterToInchesConversion() {
	        double inches = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
	        assertEquals(1.0, inches, 1e-6);
	    }

	    @Test
	    void testAddDefaultUnitLength() {
	        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

	        QuantityLength sum = a.add(b);

	        assertEquals(2.0, sum.getValue(), LENGTH_EPSILON);
	        assertEquals(LengthUnit.FEET, sum.getUnit());
	    }

	    @Test
	    void testAddTargetUnitsLength() {
	        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

	        QuantityLength sumInFeet = a.add(b, LengthUnit.FEET);
	        QuantityLength sumInInches = a.add(b, LengthUnit.INCH);
	        QuantityLength sumInYards = a.add(b, LengthUnit.YARD);

	        assertEquals(2.0, sumInFeet.getValue(), LENGTH_EPSILON);
	        assertEquals(LengthUnit.FEET, sumInFeet.getUnit());

	        assertEquals(24.0, sumInInches.getValue(), LENGTH_EPSILON);
	        assertEquals(LengthUnit.INCH, sumInInches.getUnit());

	        assertEquals(2.0 / 3.0, sumInYards.getValue(), LENGTH_EPSILON);
	        assertEquals(LengthUnit.YARD, sumInYards.getUnit());
	    }

	    @Test
	    void testNullUnitLengthConstructor() {
	        Exception ex = assertThrows(IllegalArgumentException.class,
	                () -> new QuantityLength(1.0, null));
	        assertEquals("Unit cannot be null", ex.getMessage());
	    }

	    @Test
	    void testInvalidValueLength() {
	        Exception ex = assertThrows(IllegalArgumentException.class,
	                () -> new QuantityLength(Double.NaN, LengthUnit.FEET));
	        assertEquals("Invalid value", ex.getMessage());
	    }

	    @Test
	    void testAddNullQuantityLength() {
	        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	        Exception ex = assertThrows(IllegalArgumentException.class,
	                () -> a.add(null));
	        assertEquals("Second operand cannot be null", ex.getMessage());
	    }

	    @Test
	    void testAddNullTargetUnitLength() {
	        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
	        Exception ex = assertThrows(IllegalArgumentException.class,
	                () -> a.add(b, null));
	        assertEquals("Target unit cannot be null", ex.getMessage());
	    }

	    // ------------------ WEIGHT TESTS (UC9) ------------------

	    private static final double WEIGHT_EPSILON = 1e-5; // slightly relaxed for lb conversions

	    @Test
	    void testWeightEqualitySameUnit() {
	        QuantityWeight a = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
	        QuantityWeight b = new QuantityWeight(2.0, WeightUnit.KILOGRAM);
	        assertTrue(a.equals(b));
	    }

	    @Test
	    void testWeightEqualityDifferentUnits() {
	        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
	        QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);

	        assertTrue(kg.equals(g));
	        assertTrue(kg.equals(lb));
	    }

	    @Test
	    void testWeightConversion() {
	        QuantityWeight twoLb = new QuantityWeight(2.0, WeightUnit.POUND);
	        QuantityWeight inKg = twoLb.convertTo(WeightUnit.KILOGRAM);

	        assertEquals(0.907184, inKg.getValue(), WEIGHT_EPSILON);
	        assertEquals(WeightUnit.KILOGRAM, inKg.getUnit());
	    }

	    @Test
	    void testAddDefaultUnitWeight() {
	        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	        QuantityWeight w2 = new QuantityWeight(500.0, WeightUnit.GRAM);

	        QuantityWeight sum = w1.add(w2);
	        assertEquals(1.5, sum.getValue(), WEIGHT_EPSILON);
	        assertEquals(WeightUnit.KILOGRAM, sum.getUnit());
	    }

	    @Test
	    void testAddTargetUnitWeight() {
	        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	        QuantityWeight w2 = new QuantityWeight(500.0, WeightUnit.GRAM);

	        QuantityWeight sumInLb = w1.add(w2, WeightUnit.POUND);
	        assertEquals(3.3069337, sumInLb.getValue(), WEIGHT_EPSILON);
	        assertEquals(WeightUnit.POUND, sumInLb.getUnit());
	    }

	    @Test
	    void testWeightCategorySafety() {
	        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	        QuantityLength l = new QuantityLength(1.0, LengthUnit.FEET);

	        assertFalse(w.equals(l)); // cross-category comparison must fail
	    }

	    @Test
	    void testInvalidValueAndNullWeight() {
	        assertThrows(IllegalArgumentException.class, () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
	        assertThrows(IllegalArgumentException.class, () -> new QuantityWeight(1.0, null));
	    }

	    @Test
	    void testAddNullOperandWeight() {
	        QuantityWeight w = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
	        assertThrows(IllegalArgumentException.class, () -> w.add(null));
	        assertThrows(IllegalArgumentException.class, () -> w.add(null, WeightUnit.KILOGRAM));
	        assertThrows(IllegalArgumentException.class, () -> w.add(w, null));
	    }
	    
}
