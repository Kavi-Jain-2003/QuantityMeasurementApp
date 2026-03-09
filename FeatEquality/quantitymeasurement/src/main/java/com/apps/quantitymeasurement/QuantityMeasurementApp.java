package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCH);

        System.out.println("1 Foot equals 12 Inches: " + feet.equals(inches));

        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("1 kg equals 1000 g: " + kg.equals(g));

        Quantity<WeightUnit> sum = kg.add(new Quantity<>(500.0, WeightUnit.GRAM));
        System.out.println("Sum in default unit: " + sum);

        Quantity<WeightUnit> sumInLb = kg.add(new Quantity<>(500.0, WeightUnit.GRAM), WeightUnit.POUND);
        System.out.println("Sum in Pounds: " + sumInLb);
    }
}
