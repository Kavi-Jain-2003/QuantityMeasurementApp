package com.apps.quantitymeasurement.unit;
public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001);

    private final double conversionFactor;

    VolumeUnit(double factor) {
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
