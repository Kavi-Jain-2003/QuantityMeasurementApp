package com.apps.quantitymeasurement;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {

    //uc1

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(
            QuantityMeasurementApp.checkFeetEquality(1.0, 1.0),
            "1.0 ft should equal 1.0 ft"
        );
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(
            QuantityMeasurementApp.checkFeetEquality(1.0, 2.0),
            "1.0 ft should not equal 2.0 ft"
        );
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet),
                "Object should equal itself (Reflexive)");
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null),
                "Feet should not equal null");
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals("abc"),
                "Feet should not equal non-numeric input");
    }

  //uc2

    @Test
    void testInchEquality_SameValue() {
        assertTrue(
            QuantityMeasurementApp.checkInchesEquality(1.0, 1.0),
            "1.0 inch should equal 1.0 inch"
        );
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(
            QuantityMeasurementApp.checkInchesEquality(1.0, 2.0),
            "1.0 inch should not equal 2.0 inch"
        );
    }

    @Test
    void testInchEquality_SameReference() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inch.equals(inch),
                "Object should equal itself (Reflexive)");
    }

    @Test
    void testInchEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals(null),
                "Inch should not equal null");
    }

    @Test
    void testInchEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals("xyz"),
                "Inch should not equal non-numeric input");
    }
}
