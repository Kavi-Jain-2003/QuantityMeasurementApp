package com.apps.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON=0.001;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new NullPointerException("Unit cannot be null");
        if(!Double.isFinite(value)) 
        	throw new IllegalArgumentException("Invalid number");
        this.value = value;
        this.unit = unit;
    }

    private double toBaseValue() {
        return unit.toFeet(value);
    }
    public Length add(Length other) {
        return Length.add(this, other, this.unit);
    }
  
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

        return Math.abs(this.toBaseValue()- other.toBaseValue()) <EPSILON;
    }

    @Override
    public int hashCode() {
        long rounded = Math.round(toBaseValue() / EPSILON);
        return Long.hashCode(rounded);
    }
    @Override
    public String toString(){
        return String.format("%.3f %s", value, unit);
    }
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
}