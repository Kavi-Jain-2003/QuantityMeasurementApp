package com.apps.quantitymeasurement;
import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    public Length(double value, LengthUnit unit) {

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

    public LengthUnit getUnit() {
        return unit;
    }

    // UC4 conversion (kept for backward compatibility)
    public static double convert(double value, LengthUnit from, LengthUnit to) {

        if (from == null || to == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double base = from.convertToBaseUnit(value);

        return to.convertFromBaseUnit(base);
    }

    // UC8 convertTo method
    public Length convertTo(LengthUnit targetUnit) {

        double base = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(base);

        return new Length(converted, targetUnit);
    }

    // UC6 Addition
    public Length add(Length other) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double resultValue = unit.convertFromBaseUnit(resultBase);

        return new Length(resultValue, unit);
    }

    // UC7 Addition with target unit
    public Length add(Length other, LengthUnit targetUnit) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double resultBase = base1 + base2;

        double resultValue = targetUnit.convertFromBaseUnit(resultBase);

        return new Length(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Length))
            return false;

        Length other = (Length) obj;

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
        return "Length{" + value + " " + unit + '}';
    }
}
