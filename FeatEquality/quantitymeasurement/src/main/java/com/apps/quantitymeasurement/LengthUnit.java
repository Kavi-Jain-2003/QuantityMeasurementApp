package com.apps.quantitymeasurement;
public enum LengthUnit {
	FEET(1.0),
    INCHES(1.0 / 12.0);

    private final double convertToFeet;

    LengthUnit(double convertToInch) {
        this.convertToFeet = convertToInch;
    }
    public double convertToBase(double value)
    {
    	return value*convertToFeet;
    }
}
