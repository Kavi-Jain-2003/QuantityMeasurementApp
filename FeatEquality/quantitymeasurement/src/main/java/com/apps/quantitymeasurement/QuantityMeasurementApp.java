package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Equality: " + l1.equals(l2));

        System.out.println("Conversion: " + l1.convertTo(LengthUnit.INCHES));

        System.out.println("Addition: " + l1.add(l2));

        System.out.println("Addition in yards: " + l1.add(l2, LengthUnit.YARDS));
    }
}
