package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 0.000001;

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
    public double toBaseValue(){ return unit.convertToKG(value); }
    public Weight convertTo(WeightUnit targetUnit) {

        double base = unit.convertToKG(value);

        double converted = targetUnit.convertFromKG(base);

        return new Weight(converted, targetUnit);
    }

    	 public Weight add(Weight other){
    	        return add(this, other, this.unit);
    	    }
    	    public static Weight add(Weight w1, Weight w2, WeightUnit targetUnit){

    	if(w1 == null || w2 == null) throw new IllegalArgumentException("Quantity cannot be null!");
        if(targetUnit == null) throw new IllegalArgumentException("Target Unit cannot be null!");

        double sum = w1.toBaseValue() + w2.toBaseValue(); // sum in KG

        double converted = targetUnit.convertToKG(sum);

        return new Weight(Math.round(converted * 1000.0) / 1000.0, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Weight))
            return false;

        Weight other = (Weight) obj;

        return Math.abs(this.toBaseValue() - other.toBaseValue()) < EPSILON;
    }

    @Override
    public int hashCode() {

        double base = unit.convertToKG(value);

        return Objects.hash(Math.round(base / EPSILON));
    }

    @Override
    public String toString() {
        return "Weight{" + value + " " + unit + '}';
    }
}
