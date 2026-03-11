package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

		// -------- Temperature Equality --------
		Quantity<TemperatureUnit> t1 = new Quantity<>(0, TemperatureUnit.CELSIUS);

		Quantity<TemperatureUnit> t2 = new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

		System.out.println("Temperature Equality:");
		System.out.println(t1.equals(t2));

		// -------- Temperature Conversion --------
		Quantity<TemperatureUnit> temp = new Quantity<>(100, TemperatureUnit.CELSIUS);

		System.out.println("Convert to Fahrenheit:");
		System.out.println(temp.convertTo(TemperatureUnit.FAHRENHEIT));

		// -------- Unsupported Operation --------
		try {

			Quantity<TemperatureUnit> a = new Quantity<>(100, TemperatureUnit.CELSIUS);

			Quantity<TemperatureUnit> b = new Quantity<>(50, TemperatureUnit.CELSIUS);

			System.out.println(a.add(b));

		} catch (UnsupportedOperationException e) {

			System.out.println(e.getMessage());
		}
	}
}
