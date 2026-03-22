package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Case 1: 1 ft = 12 in
    public static void demonstrateFeetInchesComparison1() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("1 ft == 12 in : " +
                demonstrateLengthEquality(feet1, inch1));
    }

    // Case 2: 2 ft = 24 in
    public static void demonstrateFeetInchesComparison2() {

        Length feet2 = new Length(2.0, LengthUnit.FEET);
        Length inch2 = new Length(24.0, LengthUnit.INCHES);

        System.out.println("2 ft == 24 in : " +
                demonstrateLengthEquality(feet2, inch2));
    }

    public static void main(String[] args) {

        demonstrateFeetInchesComparison1();
        demonstrateFeetInchesComparison2();
    }
}
