package com.apps.quantitymeasurement;
public enum WeightUnit implements IMeasurable {

    GRAM(1.0),
    KILOGRAM(1000.0);

    private final double conversionFactor;

    WeightUnit(double factor) {
        this.conversionFactor = factor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double value) {
        return value / conversionFactor;
    }
}
