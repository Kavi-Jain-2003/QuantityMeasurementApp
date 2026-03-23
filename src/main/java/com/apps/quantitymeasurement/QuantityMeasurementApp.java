package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        demonstrateLength();
        demonstrateWeight();
        demonstrateVolume();
    }

    //  LENGTH 
    public static void demonstrateLength() {

        System.out.println("----- LENGTH -----");

        Quantity<LengthUnit> f = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> i = new Quantity<>(12, LengthUnit.INCH);
        Quantity<LengthUnit> y = new Quantity<>(1, LengthUnit.YARDS);
        Quantity<LengthUnit> cm = new Quantity<>(30.48, LengthUnit.CENTIMETER);

        // Equality
        System.out.println("1 ft == 12 inch: " + f.equals(i));
        System.out.println("1 yard == 3 ft: " + y.equals(new Quantity<>(3, LengthUnit.FEET)));
        System.out.println("30.48 cm == 1 ft: " + cm.equals(f));

        // Conversion
        System.out.println("1 ft in inch: " + f.convertTo(LengthUnit.INCH));
        System.out.println("1 yard in feet: " + y.convertTo(LengthUnit.FEET));
        System.out.println("1 ft in cm: " + f.convertTo(LengthUnit.CENTIMETER));

        // Addition
        System.out.println("1 ft + 12 inch: " + f.add(i));
        System.out.println("1 ft + 12 inch (inch): " + f.add(i, LengthUnit.INCH));

        // Subtraction
        System.out.println("1 ft - 6 inch: " + f.subtract(new Quantity<>(6, LengthUnit.INCH)));
        System.out.println("1 ft - 6 inch (inch): " + f.subtract(new Quantity<>(6, LengthUnit.INCH), LengthUnit.INCH));

        // Division
        System.out.println("1 yard / 1 ft: " + y.divide(f));
    }

    // WEIGHT
    public static void demonstrateWeight() {

        System.out.println("\n----- WEIGHT -----");

        Quantity<WeightUnit> kg = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000, WeightUnit.GRAM);
        Quantity<WeightUnit> lb = new Quantity<>(2.20462, WeightUnit.POUND);

        // Equality
        System.out.println("1 kg == 1000 g: " + kg.equals(g));
        System.out.println("1 kg == 2.20462 pound: " + kg.equals(lb));

        // Conversion
        System.out.println("1 kg in gram: " + kg.convertTo(WeightUnit.GRAM));
        System.out.println("1 kg in pound: " + kg.convertTo(WeightUnit.POUND));

        // Addition
        System.out.println("1 kg + 1000 g: " + kg.add(g));
        System.out.println("1 kg + 1000 g (gram): " + kg.add(g, WeightUnit.GRAM));

        // Subtraction
        System.out.println("1 kg - 500 g: " + kg.subtract(new Quantity<>(500, WeightUnit.GRAM)));

        // Division
        System.out.println("1 kg / 1000 g: " + kg.divide(g));
    }

    // ---------------- VOLUME ----------------
    public static void demonstrateVolume() {

        System.out.println("\n----- VOLUME -----");

        Quantity<VolumeUnit> l = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(0.264172, VolumeUnit.GALLON);

        // Equality
        System.out.println("1 litre == 1000 ml: " + l.equals(ml));
        System.out.println("1 litre == 0.264 gallon: " + l.equals(gallon));

        // Conversion
        System.out.println("1 litre in ml: " + l.convertTo(VolumeUnit.MILLILITRE));
        System.out.println("1 litre in gallon: " + l.convertTo(VolumeUnit.GALLON));

        // Addition
        System.out.println("1 litre + 1000 ml: " + l.add(ml));
        System.out.println("1 litre + 1000 ml (gallon): " + l.add(ml, VolumeUnit.GALLON));

        // Subtraction
        System.out.println("1 litre - 500 ml: " + l.subtract(new Quantity<>(500, VolumeUnit.MILLILITRE)));

        // Division
        System.out.println("1 litre / 1000 ml: " + l.divide(ml));
    }
}
