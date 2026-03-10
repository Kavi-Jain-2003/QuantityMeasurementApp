package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),           // Base unit
    INCH(1.0 / 12.0),  // 1 inch = 1/12 feet
	YARDS(36.0),
    CENTIMETERS(0.393701);    

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }
}
