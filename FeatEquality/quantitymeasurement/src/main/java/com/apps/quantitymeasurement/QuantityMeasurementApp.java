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
        
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result = a.add(b);
        System.out.println(result);
        
        QuantityLength a2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b2 = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength result4 = a2.add(b2, LengthUnit.FEET);
        QuantityLength result5 = a2.add(b2, LengthUnit.INCH);
        QuantityLength result6 = a2.add(b2, LengthUnit.YARD);

        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);

        
    }
}
