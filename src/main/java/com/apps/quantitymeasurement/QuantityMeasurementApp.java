package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

//        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
//        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCH);
//
//        System.out.println("1 Foot equals 12 Inches: " + feet.equals(inches));
//
//        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
//        Quantity<WeightUnit> g = new Quantity<>(1000.0, WeightUnit.GRAM);
//
//        System.out.println("1 kg equals 1000 g: " + kg.equals(g));
//
//        Quantity<WeightUnit> sum = kg.add(new Quantity<>(500.0, WeightUnit.GRAM));
//        System.out.println("Sum in default unit: " + sum);
//
//        Quantity<WeightUnit> sumInLb = kg.add(new Quantity<>(500.0, WeightUnit.GRAM), WeightUnit.POUND);
//        System.out.println("Sum in Pounds: " + sumInLb);
//        
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> v3 = new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println("1 L = 1000 mL: " + v1.equals(v2));
        System.out.println("1 Gallon in Litres: " + v3.convertTo(VolumeUnit.LITRE));

        Quantity<VolumeUnit> sum = v1.add(v2);
        System.out.println("Sum: " + sum);

        Quantity<VolumeUnit> sumMl = v1.add(v3, VolumeUnit.MILLILITRE);
        System.out.println("Sum in mL: " + sumMl);
        
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCH);

        Quantity<LengthUnit> diff = l1.subtract(l2);
        System.out.println("Subtraction: " + diff);

        double ratio = l1.divide(l2);
        System.out.println("Division ratio: " + ratio);


    }
}
