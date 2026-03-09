package com.apps.quantitymeasurement;

public enum WeightUnit {

    KILOGRAM(1.0),        // Base unit
    GRAM(0.001),          // 1 g = 0.001 kg
    POUND(0.453592);      // 1 lb ≈ 0.453592 kg

    private final double factorToKg;

    WeightUnit(double factorToKg) {
        this.factorToKg = factorToKg;
    }

    public double toKg(double value) {
        return value * factorToKg;
    }

    public double fromKg(double kgValue) {
        return kgValue / factorToKg;
    }
}
