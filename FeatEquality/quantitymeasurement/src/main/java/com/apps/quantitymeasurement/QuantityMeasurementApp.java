package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // 1️ Equality
    public static <U extends IMeasurable> void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(q1 + " equals " + q2 + " : " + q1.equals(q2));
    }

    // 2️ Conversion
    public static <U extends IMeasurable> void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(quantity + " -> " + quantity.convertTo(targetUnit));
    }

    // 3️ Addition (same unit result)
    public static <U extends IMeasurable> void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(q1 + " + " + q2 + " = " + q1.add(q2));
    }

    // 4️ Addition (target unit result)
    public static <U extends IMeasurable> void demonstrateAdditionWithTarget(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(q1 + " + " + q2 + " = " + q1.add(q2, targetUnit));
    }

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        demonstrateEquality(l1, l2);
        demonstrateConversion(l1, LengthUnit.INCHES);
        demonstrateAddition(l1, l2);
        demonstrateAdditionWithTarget(l1, l2, LengthUnit.FEET);

        System.out.println();

        // WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        demonstrateEquality(w1, w2);
        demonstrateConversion(w1, WeightUnit.GRAM);
        demonstrateAddition(w1, w2);
        demonstrateAdditionWithTarget(w1, w2, WeightUnit.KILOGRAM);
    }
}
