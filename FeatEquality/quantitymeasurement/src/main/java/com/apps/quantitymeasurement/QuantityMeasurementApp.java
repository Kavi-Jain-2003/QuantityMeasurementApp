package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // LENGTH DEMOS
        lengthEqualityDemo();
        lengthConversionDemo();
        lengthAdditionDemo();
        lengthAdditionTargetUnitDemo();
        lengthUnitConversionMethodsDemo();
        lengthCrossUnitEqualityDemo();

        // WEIGHT DEMOS
        weightEqualityDemo();
        weightConversionDemo();
        weightAdditionDemo();
        weightAdditionTargetUnitDemo();
        weightCrossUnitEqualityDemo();
        weightUnitConversionMethodsDemo();
    }

    // ---------- LENGTH METHODS ----------

    static void lengthEqualityDemo() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Length Equality: " + l1.equals(l2));
    }

    static void lengthConversionDemo() {

        Length l = new Length(1, LengthUnit.FEET);

        System.out.println("1 FEET in INCHES: " + l.convertTo(LengthUnit.INCHES));
    }

    static void lengthAdditionDemo() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Addition (default): " + l1.add(l2));
    }

    static void lengthAdditionTargetUnitDemo() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println("Addition in YARDS: " + Length.add(l1, l2, LengthUnit.YARDS));
    }

    static void lengthUnitConversionMethodsDemo() {

        System.out.println("12 inches to feet: " + LengthUnit.INCHES.toFeet(12));
        System.out.println("1 foot to inches: " + LengthUnit.INCHES.fromFeet(1));
    }

    static void lengthCrossUnitEqualityDemo() {

        Length l1 = new Length(36, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.YARDS);

        System.out.println("36 inches == 1 yard: " + l1.equals(l2));
    }

    // ---------- WEIGHT METHODS ----------

    static void weightEqualityDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + w1.equals(w2));
    }

    static void weightConversionDemo() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        System.out.println("1 KG in GRAM: " + w.convertTo(WeightUnit.GRAM));
    }

    static void weightAdditionDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Addition (default): " + w1.add(w2));
    }

    static void weightAdditionTargetUnitDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Addition in GRAM: " + Weight.add(w1, w2, WeightUnit.GRAM));
    }

    static void weightCrossUnitEqualityDemo() {

        Weight w1 = new Weight(1, WeightUnit.POUND);
        Weight w2 = new Weight(453.592, WeightUnit.GRAM);

        System.out.println("1 pound == 453.592g: " + w1.equals(w2));
    }

    static void weightUnitConversionMethodsDemo() {

        System.out.println("1 pound to kg(base): " + WeightUnit.POUND.convertToKG(1));
        System.out.println("1 kg(base) to pound: " + WeightUnit.POUND.convertFromKG(1));
    }
}
