package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0/12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

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
    public double getFeetFactor()
    {
    	return convertToFeet;
    }
    
}
