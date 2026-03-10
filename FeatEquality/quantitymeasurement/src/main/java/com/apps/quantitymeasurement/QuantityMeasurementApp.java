package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }


    public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                      double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }


    public static double demonstrateLengthConversion(double value,
                                                     LengthUnit from,
                                                     LengthUnit to) {

        return Length.convert(value, from, to);
    }


    public static Length demonstrateLengthConversion(Length length,
                                                     LengthUnit to) {

        return length.convertTo(to);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {

        return l1.add(l2);
    }


    public static Length demonstrateLengthAddition(Length l1,
                                                   Length l2,
                                                   LengthUnit targetUnit) {

        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        Length result1 = demonstrateLengthAddition(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES),
                LengthUnit.FEET);

        System.out.println(result1);

        Length result2 = demonstrateLengthAddition(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES),
                LengthUnit.YARDS);

        System.out.println(result2);
    }
}