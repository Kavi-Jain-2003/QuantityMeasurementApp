package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    /* 1 Equality */
    public static void demonstrateEquality() {

        // Length
        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Equality: " + l1.equals(l2));

        // Weight
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + w1.equals(w2));

        // Volume
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Equality: " + v1.equals(v2));
    }

    /* 2 Conversion */
    public static void demonstrateConversion() {

        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        System.out.println("1 Foot to Inches: " + length.convertTo(LengthUnit.INCHES));

        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        System.out.println("1 Kg to Gram: " + weight.convertTo(WeightUnit.GRAM));

        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        System.out.println("1 Litre to Gallon: " + volume.convertTo(VolumeUnit.GALLON));
    }

    /* 3 Addition (implicit unit) */
    public static void demonstrateAdditionImplicit() {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Add: " + l1.add(l2));

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Add: " + w1.add(w2));

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Add: " + v2.add(v1));
    }

    /* 4 Addition (explicit unit) */
    public static void demonstrateAdditionExplicit() {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Add in Inches: "
                + l1.add(l2, LengthUnit.INCHES));

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight Add in Gram: "
                + w1.add(w2, WeightUnit.GRAM));

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Add in Gallon: "
                + v1.add(v2, VolumeUnit.GALLON));
    }

    /* 5 Subtraction (implicit unit) */
    public static void demonstrateSubtractionImplicit() {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Subtract: " + l1.subtract(l2));
    }

    /* 6 Subtraction (explicit unit) */
    public static void demonstrateSubtractionExplicit() {

        Quantity<LengthUnit> l1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length Subtract in Inches: "
                + l1.subtract(l2, LengthUnit.INCHES));
    }

    /* 7 Division */
    public static void demonstrateDivision() {

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Division (Weight Ratio): " + w1.divide(w2));
    }

    public static void main(String[] args) {

        demonstrateEquality();
        demonstrateConversion();

        demonstrateAdditionImplicit();
        demonstrateAdditionExplicit();

        demonstrateSubtractionImplicit();
        demonstrateSubtractionExplicit();

        demonstrateDivision();
    }
}
