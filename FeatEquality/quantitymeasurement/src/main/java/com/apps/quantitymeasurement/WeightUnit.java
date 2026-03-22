package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKG;

    WeightUnit(double toKG) {
        this.toKG = toKG;
    }

    public double getCoversionFactor() {
        return toKG;
    }

    // Convert to base unit (kilogram)
    public double convertToKG(double value) {
        return value * toKG;
    }

    // Convert from kilogram to this unit
    public double convertFromKG(double baseValue) {
        return baseValue / toKG;
    }
}
