package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),           // Base unit
    INCH(1.0 / 12.0),  // 1 inch = 1/12 feet
	YARDS(3.0),	//1yard=3feet
    CENTIMETERS(1/30.48);    //1cm=1/30.48feet

    private final double convertToFeet;

    LengthUnit(double convertToFeet) {
        this.convertToFeet = convertToFeet;
    }

    public double convertToBase(double value) {
        return value * convertToFeet;
    }
}
