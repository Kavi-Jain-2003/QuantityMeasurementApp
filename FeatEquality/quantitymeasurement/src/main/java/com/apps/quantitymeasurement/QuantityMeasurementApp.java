package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inch = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Result (default unit): " + feet.add(inch));

        System.out.println("Target FEET: " + Length.add(feet, inch, LengthUnit.FEET));
        System.out.println("Target INCH: " + Length.add(feet, inch, LengthUnit.INCHES));
        System.out.println("Target YARDS: " + Length.add(feet, inch, LengthUnit.YARDS));
        System.out.println("Target CM: " + Length.add(feet, inch, LengthUnit.CENTIMETERS));
    }
}
