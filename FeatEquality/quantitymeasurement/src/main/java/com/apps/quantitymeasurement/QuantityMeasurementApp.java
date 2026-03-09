package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // UC1–UC4 Equality Demo
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("1 Foot equals 12 Inches: " + feet.equals(inches));

        // UC5 Conversion Demo
        System.out.println("1 Foot in Inches: " + QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
        System.out.println("3 Yards in Feet: " + QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET));
        System.out.println("2.54 cm in Inches: " + QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH));

        // UC6 Addition Demo
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("Sum in default unit: " + a.add(b));

        // UC7 Addition with target unit
        System.out.println("Sum in Feet: " + a.add(b, LengthUnit.FEET));
        System.out.println("Sum in Inches: " + a.add(b, LengthUnit.INCH));
        System.out.println("Sum in Yards: " + a.add(b, LengthUnit.YARD));
    }
}
