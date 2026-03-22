package com.apps.quantitymeasurement;

public enum LengthUnit {

    INCHES(1.0),
    FEET(12.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double convertToFeet;

    LengthUnit(double convertToFeet) {
        this.convertToFeet = convertToFeet;
    }

    public double toFeet(double value) {
        return value * convertToFeet;
    }

    public double fromFeet(double baseValue) {
        return baseValue / convertToFeet;
    }
    public double feetFactor()
    {
    	return convertToFeet;
    }
}
