package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new NullPointerException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    private double toBaseValue() {
        return unit.toFeet(value);
    }

    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double base1 = this.toBaseValue();
        double base2 = other.toBaseValue();

        double sumBase = base1 + base2;

        double result = this.unit.fromFeet(sumBase);

        return new Length(result, this.unit);
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Length))
            return false;

        Length other = (Length) obj;

        return Double.compare(this.toBaseValue(), other.toBaseValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBaseValue());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
