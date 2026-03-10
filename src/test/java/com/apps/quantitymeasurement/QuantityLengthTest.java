package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    private static final double LENGTH_EPSILON = 0.0001;
    private static final double WEIGHT_EPSILON = 1e-5;

    // ------------------ LENGTH TESTS ------------------

    @Test
    void testFeetEqualsInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCH);

        assertTrue(feet.equals(inches), "1 Foot should equal 12 Inches");
    }

    @Test
    void testYardEqualsFeet() {
        Quantity<LengthUnit> yard = new Quantity<>(1.0, LengthUnit.YARD);
        Quantity<LengthUnit> feet = new Quantity<>(3.0, LengthUnit.FEET);

        assertTrue(yard.equals(feet), "1 Yard should equal 3 Feet");
    }

    @Test
    void testFeetToInchesConversion() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = feet.convertTo(LengthUnit.INCH);

        assertEquals(12.0, inches.getValue(), LENGTH_EPSILON);
        assertEquals(LengthUnit.INCH, inches.getUnit());
    }

    @Test
    void testCentimeterToInchesConversion() {
        Quantity<LengthUnit> cm = new Quantity<>(2.54, LengthUnit.CENTIMETER);
        Quantity<LengthUnit> inches = cm.convertTo(LengthUnit.INCH);

        assertEquals(1.0, inches.getValue(), 1e-6);
        assertEquals(LengthUnit.INCH, inches.getUnit());
    }

    @Test
    void testAddDefaultUnitLength() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> sum = a.add(b);

        assertEquals(2.0, sum.getValue(), LENGTH_EPSILON);
        assertEquals(LengthUnit.FEET, sum.getUnit());
    }

    @Test
    void testAddTargetUnitLength() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> sumInFeet = a.add(b, LengthUnit.FEET);
        Quantity<LengthUnit> sumInInches = a.add(b, LengthUnit.INCH);
        Quantity<LengthUnit> sumInYards = a.add(b, LengthUnit.YARD);

        assertEquals(2.0, sumInFeet.getValue(), LENGTH_EPSILON);
        assertEquals(LengthUnit.FEET, sumInFeet.getUnit());

        assertEquals(24.0, sumInInches.getValue(), LENGTH_EPSILON);
        assertEquals(LengthUnit.INCH, sumInInches.getUnit());

        assertEquals(2.0 / 3.0, sumInYards.getValue(), LENGTH_EPSILON);
        assertEquals(LengthUnit.YARD, sumInYards.getUnit());
    }

    @Test
    void testInvalidValueAndNullLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testAddNullOperandLength() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> a.add(null));
        assertThrows(IllegalArgumentException.class, () -> a.add(a, null));
    }

    // ------------------ WEIGHT TESTS ------------------

    @Test
    void testWeightEqualitySameUnit() {
        Quantity<WeightUnit> a = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        assertTrue(a.equals(b));
    }

    @Test
    void testWeightEqualityDifferentUnits() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> lb = new Quantity<>(2.20462, WeightUnit.POUND);

        assertTrue(kg.equals(g));
        assertTrue(kg.equals(lb));
    }

    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> twoLb = new Quantity<>(2.0, WeightUnit.POUND);
        Quantity<WeightUnit> inKg = twoLb.convertTo(WeightUnit.KILOGRAM);

        assertEquals(0.907184, inKg.getValue(), WEIGHT_EPSILON);
        assertEquals(WeightUnit.KILOGRAM, inKg.getUnit());
    }

    @Test
    void testAddDefaultUnitWeight() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> sum = w1.add(w2);
        assertEquals(1.5, sum.getValue(), WEIGHT_EPSILON);
        assertEquals(WeightUnit.KILOGRAM, sum.getUnit());
    }

    @Test
    void testAddTargetUnitWeight() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> sumInLb = w1.add(w2, WeightUnit.POUND);
        assertEquals(3.3069337, sumInLb.getValue(), WEIGHT_EPSILON);
        assertEquals(WeightUnit.POUND, sumInLb.getUnit());
    }

    @Test
    void testWeightCategorySafety() {
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(w.equals(l)); // cross-category comparison must fail
    }

    @Test
    void testInvalidValueAndNullWeight() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, WeightUnit.KILOGRAM));
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testAddNullOperandWeight() {
        Quantity<WeightUnit> w = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> w.add(null));
        assertThrows(IllegalArgumentException.class, () -> w.add(null, WeightUnit.KILOGRAM));
        assertThrows(IllegalArgumentException.class, () -> w.add(w, null));
    }
    
 // ------------------ VOLUME TESTS (UC11) ------------------

    private static final double VOLUME_EPSILON = 1e-4;

    @Test
    void testLitreEqualsMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(litre.equals(ml));
    }

    @Test
    void testGallonEqualsLitre() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertTrue(gallon.equals(litre));
    }

    @Test
    void testMillilitreEqualsGallon() {
        Quantity<VolumeUnit> ml = new Quantity<>(3785.41, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);

        assertTrue(ml.equals(gallon));
    }

    @Test
    void testVolumeConversion() {

        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml = litre.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(1000.0, ml.getValue(), VOLUME_EPSILON);

        Quantity<VolumeUnit> gallon = litre.convertTo(VolumeUnit.GALLON);
        assertEquals(0.264172, gallon.getValue(), VOLUME_EPSILON);
    }

    @Test
    void testVolumeAdditionDefaultUnit() {

        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> sum = litre.add(ml);

        assertEquals(2.0, sum.getValue(), VOLUME_EPSILON);
        assertEquals(VolumeUnit.LITRE, sum.getUnit());
    }

    @Test
    void testVolumeAdditionDifferentUnits() {

        Quantity<VolumeUnit> ml = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> litre = new Quantity<>(0.5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> sum = ml.add(litre);

        assertEquals(1000.0, sum.getValue(), VOLUME_EPSILON);
        assertEquals(VolumeUnit.MILLILITRE, sum.getUnit());
    }

    @Test
    void testVolumeAdditionTargetUnit() {

        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = litre.add(gallon, VolumeUnit.MILLILITRE);

        assertEquals(4785.41, result.getValue(), VOLUME_EPSILON);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testVolumeCategorySafety() {

        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(volume.equals(length));
        assertFalse(volume.equals(weight));
    }

    @Test
    void testVolumeSameReference() {

        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertTrue(volume.equals(volume));
    }

    @Test
    void testVolumeDifferentValues() {

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertFalse(v1.equals(v2));
    }
    @Test
    void testSubtractSameUnitLength() {

        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.subtract(b);

        assertEquals(5.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtractDifferentUnitsLength() {

        Quantity<LengthUnit> feet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(6.0, LengthUnit.INCH);

        Quantity<LengthUnit> result = feet.subtract(inches);

        assertEquals(9.5, result.getValue());
    }

    @Test
    void testSubtractWithTargetUnit() {

        Quantity<VolumeUnit> litre = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = litre.subtract(ml, VolumeUnit.MILLILITRE);

        assertEquals(1500.0, result.getValue());
    }
    @Test
    void testSubtractNegativeResult() {

        Quantity<WeightUnit> a = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = a.subtract(b);

        assertEquals(-3.0, result.getValue());
    }
    @Test
    void testSubtractZeroResult() {

        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = a.subtract(b);

        assertEquals(0.0, result.getValue());
    }
    @Test
    void testDivisionSameUnit() {

        Quantity<WeightUnit> a = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        double result = a.divide(b);

        assertEquals(2.0, result);
    }
    @Test
    void testDivisionDifferentUnits() {

        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        double result = litre.divide(ml);

        assertEquals(2.0, result);
    }
    @Test
    void testDivisionLessThanOne() {

        Quantity<WeightUnit> a = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(10.0, WeightUnit.KILOGRAM);

        double result = a.divide(b);

        assertEquals(0.5, result);
    }
    @Test
    void testDivisionByZero() {

        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> a.divide(b));
    }
    @Test
    void testDivisionCategorySafety() {

        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.divide((Quantity) weight);
        });
    }
    // ---------- ADDITION TESTS ----------

    @Test
    void givenSameLengthUnits_whenAdded_shouldReturnCorrectResult() {

        Quantity<LengthUnit> a = new Quantity<>(5, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = a.add(b);

        assertEquals(10, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void givenDifferentLengthUnits_whenAdded_shouldReturnCorrectResult() {

        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inch = new Quantity<>(12, LengthUnit.INCH);

        Quantity<LengthUnit> result = feet.add(inch);

        assertEquals(2, result.getValue());
    }

    @Test
    void givenVolumeUnits_whenAddedWithTargetUnit_shouldReturnCorrectResult() {

        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = litre.add(ml, VolumeUnit.MILLILITRE);

        assertEquals(1500, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    // ---------- SUBTRACTION TESTS ----------

    @Test
    void givenSameUnits_whenSubtracted_shouldReturnCorrectResult() {

        Quantity<WeightUnit> a = new Quantity<>(10, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(5, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = a.subtract(b);

        assertEquals(5, result.getValue());
    }

    @Test
    void givenDifferentUnits_whenSubtracted_shouldReturnCorrectResult() {

        Quantity<LengthUnit> feet = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> inch = new Quantity<>(6, LengthUnit.INCH);

        Quantity<LengthUnit> result = feet.subtract(inch);

        assertEquals(9.5, result.getValue());
    }

    @Test
    void givenUnits_whenSubtractedWithTargetUnit_shouldReturnCorrectResult() {

        Quantity<VolumeUnit> litre = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = litre.subtract(ml, VolumeUnit.MILLILITRE);

        assertEquals(1500, result.getValue());
    }

    @Test
    void givenSmallerValueMinusLarger_whenSubtracted_shouldReturnNegative() {

        Quantity<WeightUnit> a = new Quantity<>(2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(5, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = a.subtract(b);

        assertEquals(-3, result.getValue());
    }

    @Test
    void givenEqualQuantities_whenSubtracted_shouldReturnZero() {

        Quantity<VolumeUnit> a = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = a.subtract(b);

        assertEquals(0, result.getValue());
    }

    // ---------- DIVISION TESTS ----------

    @Test
    void givenSameUnits_whenDivided_shouldReturnCorrectRatio() {

        Quantity<WeightUnit> a = new Quantity<>(10, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(5, WeightUnit.KILOGRAM);

        double result = a.divide(b);

        assertEquals(2.0, result);
    }

    @Test
    void givenDifferentUnits_whenDivided_shouldReturnCorrectRatio() {

        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(500, VolumeUnit.MILLILITRE);

        double result = litre.divide(ml);

        assertEquals(2.0, result);
    }

    @Test
    void givenSmallerDividedByLarger_shouldReturnLessThanOne() {

        Quantity<WeightUnit> a = new Quantity<>(5, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> b = new Quantity<>(10, WeightUnit.KILOGRAM);

        double result = a.divide(b);

        assertEquals(0.5, result);
    }

    @Test
    void givenEqualQuantities_whenDivided_shouldReturnOne() {

        Quantity<LengthUnit> a = new Quantity<>(12, LengthUnit.INCH);
        Quantity<LengthUnit> b = new Quantity<>(1, LengthUnit.FEET);

        double result = a.divide(b);

        assertEquals(1.0, result);
    }

    @Test
    void givenZeroDivisor_whenDivided_shouldThrowException() {

        Quantity<LengthUnit> a = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> a.divide(b));
    }

    // ---------- VALIDATION TESTS ----------

    @Test
    void givenNullOperand_whenAdd_shouldThrowException() {

        Quantity<LengthUnit> a = new Quantity<>(10, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }

    @Test
    void givenNullOperand_whenSubtract_shouldThrowException() {

        Quantity<LengthUnit> a = new Quantity<>(10, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.subtract(null));
    }

    @Test
    void givenNullOperand_whenDivide_shouldThrowException() {

        Quantity<LengthUnit> a = new Quantity<>(10, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.divide(null));
    }

    @Test
    void givenDifferentMeasurementCategories_whenAdded_shouldThrowException() {

        Quantity<LengthUnit> length = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.add((Quantity) weight);
        });
    }

    @Test
    void givenDifferentMeasurementCategories_whenSubtracted_shouldThrowException() {

        Quantity<LengthUnit> length = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.subtract((Quantity) weight);
        });
    }

    @Test
    void givenDifferentMeasurementCategories_whenDivided_shouldThrowException() {

        Quantity<LengthUnit> length = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.divide((Quantity) weight);
        });
    }
   
        @Test
        void shouldReturnTrueForSameCelsiusTemperature() {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(0, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(0, TemperatureUnit.CELSIUS);

            assertEquals(t1, t2);
        }

        @Test
        void shouldReturnTrueForCelsiusAndFahrenheitEquality() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(0, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> fahrenheit =
                    new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

            assertEquals(celsius, fahrenheit);
        }

        @Test
        void shouldReturnTrueForBoilingPointEquality() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(100, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> fahrenheit =
                    new Quantity<>(212, TemperatureUnit.FAHRENHEIT);

            assertEquals(celsius, fahrenheit);
        }

        @Test
        void shouldReturnTrueForNegativeFortyEquality() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(-40, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> fahrenheit =
                    new Quantity<>(-40, TemperatureUnit.FAHRENHEIT);

            assertEquals(celsius, fahrenheit);
        }

        // ---------- Conversion Tests ----------

        @Test
        void shouldConvertCelsiusToFahrenheit() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(100, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> result =
                    celsius.convertTo(TemperatureUnit.FAHRENHEIT);

            assertEquals(212, result.getValue(), EPSILON);
        }

        @Test
        void shouldConvertFahrenheitToCelsius() {

            Quantity<TemperatureUnit> fahrenheit =
                    new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

            Quantity<TemperatureUnit> result =
                    fahrenheit.convertTo(TemperatureUnit.CELSIUS);

            assertEquals(0, result.getValue(), EPSILON);
        }

        @Test
        void shouldConvertCelsiusToKelvin() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(0, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> result =
                    celsius.convertTo(TemperatureUnit.KELVIN);

            assertEquals(273.15, result.getValue(), EPSILON);
        }

        @Test
        void shouldConvertKelvinToCelsius() {

            Quantity<TemperatureUnit> kelvin =
                    new Quantity<>(273.15, TemperatureUnit.KELVIN);

            Quantity<TemperatureUnit> result =
                    kelvin.convertTo(TemperatureUnit.CELSIUS);

            assertEquals(0, result.getValue(), EPSILON);
        }

        // ---------- Arithmetic Restriction Tests ----------

        @Test
        void shouldThrowExceptionWhenAddingTemperature() {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(30, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(10, TemperatureUnit.CELSIUS);

            assertThrows(UnsupportedOperationException.class,
                    () -> t1.add(t2));
        }

        @Test
        void shouldThrowExceptionWhenSubtractingTemperature() {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(30, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(10, TemperatureUnit.CELSIUS);

            assertThrows(UnsupportedOperationException.class,
                    () -> t1.subtract(t2));
        }

        @Test
        void shouldThrowExceptionWhenDividingTemperature() {

            Quantity<TemperatureUnit> t1 =
                    new Quantity<>(30, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> t2 =
                    new Quantity<>(10, TemperatureUnit.CELSIUS);

            assertThrows(UnsupportedOperationException.class,
                    () -> t1.divide(t2));
        }

        // ---------- Cross Category Safety ----------

        @Test
        void shouldReturnFalseWhenComparingTemperatureWithLength() {

            Quantity<TemperatureUnit> temperature =
                    new Quantity<>(30, TemperatureUnit.CELSIUS);

            Quantity<LengthUnit> length =
                    new Quantity<>(30, LengthUnit.FEET);

            assertNotEquals(temperature, length);
        }

        // ---------- Edge Case Tests ----------

        @Test
        void shouldConvertAbsoluteZeroCorrectly() {

            Quantity<TemperatureUnit> celsius =
                    new Quantity<>(-273.15, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> fahrenheit =
                    celsius.convertTo(TemperatureUnit.FAHRENHEIT);

            assertEquals(-459.67, fahrenheit.getValue(), EPSILON);
        }

        @Test
        void shouldMaintainValueWhenConvertingSameUnit() {

            Quantity<TemperatureUnit> temp =
                    new Quantity<>(50, TemperatureUnit.CELSIUS);

            Quantity<TemperatureUnit> result =
                    temp.convertTo(TemperatureUnit.CELSIUS);

            assertEquals(50, result.getValue(), EPSILON);
        }

}
