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

        System.out.println(l.convertTo(LengthUnit.INCHES));
    }

    static void lengthAdditionDemo() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println(l1.add(l2));
    }

    static void lengthAdditionTargetUnitDemo() {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCHES);

        System.out.println(l1.add(l2, LengthUnit.YARDS));
    }

    static void lengthUnitConversionMethodsDemo() {

        System.out.println(
                LengthUnit.INCHES.convertToBaseUnit(12));

        System.out.println(
                LengthUnit.INCHES.convertFromBaseUnit(1));
    }

    static void lengthCrossUnitEqualityDemo() {

        Length l1 = new Length(36, LengthUnit.INCHES);
        Length l2 = new Length(1, LengthUnit.YARDS);

        System.out.println(l1.equals(l2));
    }

    // ---------- WEIGHT METHODS ----------

    static void weightEqualityDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + w1.equals(w2));
    }

    static void weightConversionDemo() {

        Weight w = new Weight(1, WeightUnit.KILOGRAM);

        System.out.println(w.convertTo(WeightUnit.GRAM));
    }

    static void weightAdditionDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println(w1.add(w2));
    }

    static void weightAdditionTargetUnitDemo() {

        Weight w1 = new Weight(1, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000, WeightUnit.GRAM);

        System.out.println(w1.add(w2, WeightUnit.GRAM));
    }

    static void weightCrossUnitEqualityDemo() {

        Weight w1 = new Weight(1, WeightUnit.POUND);
        Weight w2 = new Weight(453.592, WeightUnit.GRAM);

        System.out.println(w1.equals(w2));
    }

    static void weightUnitConversionMethodsDemo() {

        System.out.println(
                WeightUnit.POUND.convertToBaseUnit(1));

        System.out.println(
                WeightUnit.POUND.convertFromBaseUnit(1));
    }
}
