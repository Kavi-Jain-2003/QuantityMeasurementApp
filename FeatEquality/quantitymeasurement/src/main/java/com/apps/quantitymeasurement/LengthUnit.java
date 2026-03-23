package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {

	FEET(1.0), INCHES(1.0 / 12.0), YARDS(3.0), CENTIMETERS(0.3280839895);

	private final double convertToFeet;

	LengthUnit(double convertToFeet) {
		this.convertToFeet = convertToFeet;
	}

	@Override
	public double convertToBase(double value) {
		return value * convertToFeet;
	}

	@Override
	public double convertFromBase(double value) {
		return value / convertToFeet;
	}

	@Override
	public double getConversionFactor() {
		return convertToFeet;
	}

	@Override
	public String getUnitName() {
		return this.name();
	}
}
