package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    /* 1 Equality */
    public static void demonstrateEquality() {

        Quantity<LengthUnit> q1 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(1.0, LengthUnit.FEET);

        System.out.println("Equality Demonstration: " + q1.equals(q2));
    }

    /* 2 Conversion */
    public static void demonstrateConversion() {

        Quantity<LengthUnit> q = new Quantity<>(1.0, LengthUnit.FEET);

        double inches = LengthUnit.INCHES.convertFromBaseUnit(
                LengthUnit.FEET.convertToBaseUnit(q.getValue()));

        System.out.println("Conversion Demonstration: 1 FEET = " + inches + " INCHES");
    }

    /* 3 Addition (implicit unit) */
    public static void demonstrateAdditionImplicit() {

        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Addition (Implicit Unit): " + q1.add(q2));
    }

    /* 4 Addition (explicit unit) */
    public static void demonstrateAdditionExplicit() {

        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Addition (Explicit Unit): "
                + q1.add(q2, LengthUnit.INCHES));
    }

    /* 5 Subtraction (implicit unit) */
    public static void demonstrateSubtractionImplicit() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction (Implicit Unit): " + q1.subtract(q2));
    }

    /* 6 Subtraction (explicit unit) */
    public static void demonstrateSubtractionExplicit() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction (Explicit Unit): "
                + q1.subtract(q2, LengthUnit.INCHES));
    }

    /* 7 Division */
    public static void demonstrateDivision() {

        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        System.out.println("Division Demonstration: " + q1.divide(q2));
    }


    public static void main(String[] args) {

        demonstrateEquality();
        demonstrateConversion();

        demonstrateAdditionImplicit();
        demonstrateAdditionExplicit();

        demonstrateSubtractionImplicit();
        demonstrateSubtractionExplicit();

        demonstrateDivision();
    }
}
