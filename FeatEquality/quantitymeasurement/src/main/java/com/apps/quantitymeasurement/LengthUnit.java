package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.03280839895);

    private final double convertToFeet;

    LengthUnit(double convertToFeet) {
        this.convertToFeet = convertToFeet;
    }

    public double getconvertToFeet() {
        return convertToFeet;
    }

    // Convert value in this unit to base unit (feet)
    public double toFeet(double value) {
        return value * convertToFeet;
    }

    // Convert value from base unit (feet) to this unit
    public double fromFeet(double baseValue) {
        return baseValue / convertToFeet;
    }
    public double getFeetFactor(){ return convertToFeet; }
}
