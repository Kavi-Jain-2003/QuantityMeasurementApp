package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // -------- LENGTH ADDITION --------
        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Addition:");
        System.out.println(length1.add(length2));


        // -------- WEIGHT ADDITION --------
        Quantity<WeightUnit> weight1 =
                new Quantity<>(10.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println(weight1.add(weight2, WeightUnit.GRAM));


        // -------- SUBTRACTION --------
        Quantity<LengthUnit> length3 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> length4 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction:");
        System.out.println(length3.subtract(length4));


        // -------- VOLUME SUBTRACTION --------
        Quantity<VolumeUnit> volume1 =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        System.out.println(volume1.subtract(volume2, VolumeUnit.MILLILITRE));


        // -------- DIVISION --------
        Quantity<LengthUnit> d1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> d2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        System.out.println("Division:");
        System.out.println(d1.divide(d2));


        Quantity<LengthUnit> d3 =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> d4 =
                new Quantity<>(2.0, LengthUnit.FEET);

        System.out.println(d3.divide(d4));
    }
}
