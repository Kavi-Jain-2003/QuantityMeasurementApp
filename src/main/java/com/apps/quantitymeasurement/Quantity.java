package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double epsilon = 0.0001;

        return Math.abs(thisBase - otherBase) < epsilon;
    }

    /* ---------------- ADDITION ---------------- */

    /* Addition with implicit target unit (this unit) */
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    /* Addition with explicit target unit */
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double resultBase = thisBase + otherBase;

        double result = targetUnit.convertFromBaseUnit(resultBase);

        result = round(result);

        return new Quantity<>(result, targetUnit);
    }


    /* ---------------- SUBTRACTION ---------------- */

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double resultBase = thisBase - otherBase;

        double result = targetUnit.convertFromBaseUnit(resultBase);

        result = round(result);

        return new Quantity<>(result, targetUnit);
    }

    /* ---------------- DIVISION ---------------- */

    public double divide(Quantity<U> other) {

        validateQuantity(other);

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        if (otherBase == 0)
            throw new ArithmeticException("Division by zero quantity");

        return thisBase / otherBase;
    }

    /* ---------------- VALIDATION ---------------- */

    private void validateQuantity(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (Double.isNaN(other.value) || Double.isInfinite(other.value))
            throw new IllegalArgumentException("Invalid numeric value");
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}