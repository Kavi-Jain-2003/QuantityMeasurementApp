package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 1e-6;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    private double toKg() {
        return unit.toKg(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;
        return Math.abs(this.toKg() - other.toKg()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toKg());
    }

    @Override
    public String toString() {
        return "QuantityWeight(" + value + ", " + unit + ")";
    }

    // Convert to another weight unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double kgValue = this.toKg();
        double convertedValue = targetUnit.fromKg(kgValue);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    // Addition in first operand's unit
    public QuantityWeight add(QuantityWeight other) {
        return addInternal(other, this.unit);
    }

    // Addition with explicit target unit
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        return addInternal(other, targetUnit);
    }

    // Internal helper
    private QuantityWeight addInternal(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double sumKg = this.toKg() + other.toKg();
        double resultValue = targetUnit.fromKg(sumKg);
        return new QuantityWeight(resultValue, targetUnit);
    }
}
