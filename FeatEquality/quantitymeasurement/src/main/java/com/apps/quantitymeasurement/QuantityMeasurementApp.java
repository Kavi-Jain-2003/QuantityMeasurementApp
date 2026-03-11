package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateEquality();
        demonstrateConversion();
        demonstrateAddition();
        demonstrateAdditionWithTargetUnit();
        demonstrateUnitConversionMethods();
        demonstrateCrossUnitEquality();
    }

    // 1
    static void demonstrateEquality() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Equality: " + l1.equals(l2));
    }

    // 2
    static void demonstrateConversion() {

        Length l = new Length(1, LengthUnit.FEET);

        Length result = l.convertTo(LengthUnit.INCHES);

        System.out.println("Conversion: " + result);
    }

    // 3
    static void demonstrateAddition() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2);

        System.out.println("Addition: " + result);
    }

    // 4
    static void demonstrateAdditionWithTargetUnit() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.YARDS);

        System.out.println("Addition with target unit: " + result);
    }

    // 5
    static void demonstrateUnitConversionMethods() {

        double base = LengthUnit.INCHES.convertToBaseUnit(12);
        double inches = LengthUnit.INCHES.convertFromBaseUnit(1);

        System.out.println("12 inches to feet: " + base);
        System.out.println("1 foot to inches: " + inches);
    }

    // 6
    static void demonstrateCrossUnitEquality() {

        Length l1 = new Length(36, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.YARDS);

        System.out.println("36 inches equals 1 yard: " + l1.equals(l2));
    }
}
