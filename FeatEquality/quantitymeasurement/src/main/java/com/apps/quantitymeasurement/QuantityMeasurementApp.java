package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	 // Generic method for Length equality
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Demonstrate Feet equality
    public static void demonstrateFeetEquality() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Feet equality: " +
                demonstrateLengthEquality(length1, length2));
    }

    // Demonstrate Inches equality
    public static void demonstrateInchesEquality() {

        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Inches equality: " +
                demonstrateLengthEquality(length1, length2));
    }

    // Demonstrate Feet ↔ Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Feet to Inches comparison: " +
                demonstrateLengthEquality(length1, length2));
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}