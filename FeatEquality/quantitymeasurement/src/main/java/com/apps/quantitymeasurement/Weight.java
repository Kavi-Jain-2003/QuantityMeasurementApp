package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 0.0001;

    public Weight(double value, WeightUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
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

    public Weight convertTo(WeightUnit targetUnit) {

        double base = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(base);

        return new Weight(converted, targetUnit);
    }

    public Weight add(Weight other) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double resultValue = unit.convertFromBaseUnit(resultBase);

        return new Weight(resultValue, unit);
    }

    public Weight add(Weight other, WeightUnit targetUnit) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double resultValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Weight(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Weight))
            return false;

        Weight other = (Weight) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {

        double base = unit.convertToBaseUnit(value);

        return Objects.hash(Math.round(base / EPSILON));
    }

    @Override
    public String toString() {
        return "Weight{" + value + " " + unit + '}';
    }
}
