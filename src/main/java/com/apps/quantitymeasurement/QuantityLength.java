package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {
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

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert this quantity to feet (delegates to unit)
    private double toFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;
        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toFeet());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    // Convert between units (delegates to LengthUnit)
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");
        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double valueInFeet = source.toFeet(value);
        return target.fromFeet(valueInFeet);
    }

    // Add two quantities, default result in first operand's unit
    public QuantityLength add(QuantityLength other) {
        return addInternal(other, this.unit);
    }

    // Add two quantities and return in specific target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        return addInternal(other, targetUnit);
    }

    // Internal addition logic
    private QuantityLength addInternal(QuantityLength other, LengthUnit targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double sumInFeet = this.toFeet() + other.toFeet();
        double result = targetUnit.fromFeet(sumInFeet);
        return new QuantityLength(result, targetUnit);
    }
}
