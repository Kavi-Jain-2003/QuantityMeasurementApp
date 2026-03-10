package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	  // Generic equality method
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // UC1: Feet equality
    public static void demonstrateFeetEquality() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Feet equality: " +
                demonstrateLengthEquality(length1, length2));
    }

    // UC2: Inches equality
    public static void demonstrateInchesEquality() {

        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Inches equality: " +
                demonstrateLengthEquality(length1, length2));
    }

    // UC3: Feet to Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Feet-Inches comparison: " +
                demonstrateLengthEquality(length1, length2));
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}