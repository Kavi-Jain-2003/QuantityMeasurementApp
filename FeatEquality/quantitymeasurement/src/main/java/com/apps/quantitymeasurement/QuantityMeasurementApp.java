package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Compare two Length objects
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Compare raw values with units
    public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                      double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    // Conversion using raw values
    public static double demonstrateLengthConversion(double value,
                                                     LengthUnit from,
                                                     LengthUnit to) {

        return Length.convert(value, from, to);
    }

    // Conversion using object
    public static Length demonstrateLengthConversion(Length length,
                                                     LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

        System.out.println("1 Foot in Inches: "
                + demonstrateLengthConversion(1, LengthUnit.FEET, LengthUnit.INCHES));

        System.out.println("3 Yards in Feet: "
                + demonstrateLengthConversion(3, LengthUnit.YARDS, LengthUnit.FEET));

        System.out.println("36 Inches in Yards: "
                + demonstrateLengthConversion(36, LengthUnit.INCHES, LengthUnit.YARDS));

        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);

        System.out.println("2.54 cm in Inches: "
                + demonstrateLengthConversion(cm, LengthUnit.INCHES));
    }
}
