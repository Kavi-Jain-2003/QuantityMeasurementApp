package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // UC1–UC4 Equality Demo
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println("1 Foot equals 12 Inches: " + feet.equals(inches));

        // UC5 Conversion Demo
        double result1 = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        System.out.println("1 Foot in Inches: " + result1);

        double result2 = QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET);
        System.out.println("3 Yards in Feet: " + result2);

        double result3 = QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH);
        System.out.println("2.54 cm in Inches: " + result3);
    }
}
