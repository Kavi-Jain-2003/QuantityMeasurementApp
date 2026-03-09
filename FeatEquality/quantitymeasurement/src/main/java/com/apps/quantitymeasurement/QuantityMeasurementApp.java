package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

//        // UC1–UC4 Equality Demo
//        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
//        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCH);
//
//        System.out.println("1 Foot equals 12 Inches: " + feet.equals(inches));
//
//        // UC5 Conversion Demo
//        System.out.println("1 Foot in Inches: " + QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
//        System.out.println("3 Yards in Feet: " + QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET));
//        System.out.println("2.54 cm in Inches: " + QuantityLength.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH));
//
//        // UC6 Addition Demo
//        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
//        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);
//
//        System.out.println("Sum in default unit: " + a.add(b));
//
//        // UC7 Addition with target unit
//        System.out.println("Sum in Feet: " + a.add(b, LengthUnit.FEET));
//        System.out.println("Sum in Inches: " + a.add(b, LengthUnit.INCH));
//        System.out.println("Sum in Yards: " + a.add(b, LengthUnit.YARD));

		// Weight equality
		QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);
		QuantityWeight lb = new QuantityWeight(2.20462, WeightUnit.POUND);

		System.out.println("1 kg equals 1000 g: " + kg.equals(g));
		System.out.println("1 kg equals 2.20462 lb: " + kg.equals(lb));

		// Conversion
		System.out.println("2 lb in kg: " + new QuantityWeight(2.0, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM));
		System.out.println("500 g in lb: " + new QuantityWeight(500.0, WeightUnit.GRAM).convertTo(WeightUnit.POUND));

		// Addition
		QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
		QuantityWeight w2 = new QuantityWeight(500.0, WeightUnit.GRAM);

		QuantityWeight sumDefault = w1.add(w2); // result in w1's unit
		QuantityWeight sumInLb = w1.add(w2, WeightUnit.POUND);

		System.out.println("Sum in default unit: " + sumDefault);
		System.out.println("Sum in Pounds: " + sumInLb);
	}
}
