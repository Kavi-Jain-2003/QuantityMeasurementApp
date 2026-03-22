package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void main(String[] args) {

        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        System.out.println("Are lengths equal? " + demonstrateLengthEquality(length1, length2));
        
        Length yard = new Length(1, LengthUnit.YARDS);
        Length feet = new Length(3, LengthUnit.FEET);
        Length inch = new Length(36, LengthUnit.INCH);
        Length cm = new Length(30.48, LengthUnit.CENTIMETERS);

        System.out.println(yard.equals(feet));
        System.out.println(yard.equals(inch));
        System.out.println(cm.equals(new Length(12, LengthUnit.INCH)));

    }
}
