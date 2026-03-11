package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateLengthOperations();
        demonstrateWeightOperations();
        demonstrateVolumeOperations();
    }

    // ---------------- LENGTH DEMO ----------------

    public static void demonstrateLengthOperations() {

        System.out.println("----- Length Demonstration -----");

        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Are 1 Foot and 12 Inches equal? "
                + length1.equals(length2));

        Quantity<LengthUnit> converted =
                length1.convertTo(LengthUnit.INCHES);

        System.out.println("1 Foot in Inches: "
                + converted.getValue());

        Quantity<LengthUnit> result =
                length1.add(length2);

        System.out.println("1 Foot + 12 Inches = "
                + result.getValue() + " " + result.getUnit());
    }

    // ---------------- WEIGHT DEMO ----------------

    public static void demonstrateWeightOperations() {

        System.out.println("\n----- Weight Demonstration -----");

        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Are 1 Kg and 1000 g equal? "
                + weight1.equals(weight2));

        Quantity<WeightUnit> converted =
                weight1.convertTo(WeightUnit.GRAM);

        System.out.println("1 Kg in Grams: "
                + converted.getValue());

        Quantity<WeightUnit> result =
                weight1.add(weight2);

        System.out.println("1 Kg + 1000 g = "
                + result.getValue() + " " + result.getUnit());
    }

    // ---------------- VOLUME DEMO ----------------

    public static void demonstrateVolumeOperations() {

        System.out.println("\n----- Volume Demonstration -----");

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Are 1 Litre and 1000 ml equal? "
                + volume1.equals(volume2));

        Quantity<VolumeUnit> converted =
                volume1.convertTo(VolumeUnit.MILLILITRE);

        System.out.println("1 Litre in Millilitres: "
                + converted.getValue());

        Quantity<VolumeUnit> result =
                volume1.add(volume2);

        System.out.println("1 Litre + 1000 ml = "
                + result.getValue() + " " + result.getUnit());
    }
}
