package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factorToKg;

    WeightUnit(double factorToKg) {
        this.factorToKg = factorToKg;
    }

    @Override
    public double getConversionFactor() {
        return factorToKg;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * factorToKg;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / factorToKg;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}
