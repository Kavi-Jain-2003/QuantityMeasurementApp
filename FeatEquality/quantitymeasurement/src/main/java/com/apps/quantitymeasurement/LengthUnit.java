package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0/12),
    YARDS(3.0),
    CENTIMETERS(1.0/30.48);

    private final double convertToFeet;

    private LengthUnit(double convertToFeet) {
        this.convertToFeet = convertToFeet;
    }

    public double toFeet(double value) {
        return value * convertToFeet;
    }

    public double fromFeet(double value) {
        return value / convertToFeet;
    }
    public double getFeet()
    {
    	return convertToFeet;
    }
}