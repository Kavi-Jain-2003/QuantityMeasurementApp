package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

		demonstrateTemperatureEquality();
		demonstrateTemperatureConversion();
	}

	// -------- Temperature Equality --------
	public static void demonstrateTemperatureEquality() {

		System.out.println("----- Temperature Equality -----");

		Quantity<TemperatureUnit> t1 = new Quantity<>(0, TemperatureUnit.CELSIUS);

		Quantity<TemperatureUnit> t2 = new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

		System.out.println("0°C == 32°F : " + t1.equals(t2));
	}

	// -------- Temperature Conversion --------
	public static void demonstrateTemperatureConversion() {

		System.out.println("\n----- Temperature Conversion -----");

		Quantity<TemperatureUnit> temp = new Quantity<>(100, TemperatureUnit.CELSIUS);

		System.out.println("100°C in Fahrenheit: " + temp.convertTo(TemperatureUnit.FAHRENHEIT));
	}

}