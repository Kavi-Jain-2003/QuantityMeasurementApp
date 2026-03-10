package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 1e-6;

    public Quantity(double value, U unit) {
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

    public U getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;

        // Cross-category safety
        if (!this.unit.getClass().equals(other.unit.getClass())) return false;

        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBase());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }

    // Convert to target unit
    public Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = this.toBase();
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    // Add two quantities (result in this unit)
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // Add two quantities (result in target unit)
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBase() + other.toBase();
        double resultValue = targetUnit.convertFromBaseUnit(sumBase);
        return new Quantity<>(resultValue, targetUnit);
    }
 // subtract result in this unit
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    // subtract result in target unit
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        double baseThis = this.unit.convertToBaseUnit(this.value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        double baseResult = baseThis - baseOther;

        double resultValue = targetUnit.convertFromBaseUnit(baseResult);

        // rounding to 2 decimal places
        resultValue = Math.round(resultValue * 100.0) / 100.0;

        return new Quantity<>(resultValue, targetUnit);
    }
    public double divide(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        double baseThis = this.unit.convertToBaseUnit(this.value);
        double baseOther = other.unit.convertToBaseUnit(other.value);

        if (baseOther == 0)
            throw new ArithmeticException("Division by zero");

        return baseThis / baseOther;
    }


}
