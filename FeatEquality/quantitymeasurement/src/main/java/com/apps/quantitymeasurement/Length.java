package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON=1e-6;
    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new NullPointerException("Unit cannot be null");
        if(!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");


        this.value = value;
        this.unit = unit;
    }

    private double toBaseValue() {
        return unit.toFeet(value);
    }

    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = toBaseValue();
        double converted = targetUnit.fromFeet(baseValue);

        return new Length(converted, targetUnit);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double base = source.toFeet(value);

        return target.fromFeet(base);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Length))
            return false;

        Length other = (Length) obj;

        return Double.compare(this.toBaseValue(), other.toBaseValue()) <EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBaseValue());
    }

    @Override
    public String toString() {
        return value + " ";
    }
}
