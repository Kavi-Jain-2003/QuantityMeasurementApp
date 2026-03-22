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
    private double toBaseValue(){ return unit.toFeet(value); }


    // UC8 convertTo method
    public Length convertTo(LengthUnit targetUnit) {

        double base = this.toBaseValue();
        double converted = targetUnit.fromFeet(base);

        double rounded = Math.round(converted * 1000.0) / 1000.0;

        return new Length(rounded, targetUnit);
    }

    public Length add(Length q){ return add(this, q, this.unit); }

    public static Length add(Length q1, Length q2, LengthUnit targetUnit) throws IllegalArgumentException{
        if(q1 == null || q2 == null) throw new IllegalArgumentException("Quantity cannot be null");
        if(targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double sum = q1.toBaseValue() + q2.toBaseValue();
        double ans = targetUnit.fromFeet(sum);
        double rounded = Math.round(ans * 1000.0) / 1000.0;

        return new Length(rounded, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Length))
            return false;

        Length other = (Length) obj;

        return Math.abs(this.toBaseValue() - other.toBaseValue()) < EPSILON;
    }

    @Override
    public int hashCode() {

        return Objects.hash(Math.round(toBaseValue() / EPSILON));
    }

    @Override
    public String toString(){
        return String.format("%.3f %s", value, unit);
    }
}
