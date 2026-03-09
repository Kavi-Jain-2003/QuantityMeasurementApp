package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {
    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(0.0328084167);

    private final double factorToFeet;

    LengthUnit(double factorToFeet) {
        this.factorToFeet = factorToFeet;
    }

    @Override
    public double getConversionFactor() {
        return factorToFeet;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * factorToFeet;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factorToFeet;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
