package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    private double toFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj)
            return true;

        // Null check
        if (obj == null)
            return false;

        // Type check
        if (getClass() != obj.getClass())
            return false;

        QuantityLength other = (QuantityLength) obj;

        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toFeet());
    }
}
