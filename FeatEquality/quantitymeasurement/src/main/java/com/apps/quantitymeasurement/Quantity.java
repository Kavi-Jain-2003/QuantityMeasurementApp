
package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

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

    public U getUnit() {
        return unit;
    }
    private double toBaseValue(){
        double base = unit.convertToBase(value);
        return Math.round(base * 100000.0) / 100000.0;
    }


    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double base = this.toBaseValue();

        double converted = targetUnit.convertFromBase(base);

        double rounded = Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        double base1 = this.toBaseValue();
        double base2 = other.toBaseValue();

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBase(sumBase);

        double rounded = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Quantity<?> other = (Quantity<?>) obj;
        if(!this.unit.getClass().equals(other.unit.getClass())) return false;

        return Double.compare(this.toBaseValue(), other.toBaseValue()) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(toBaseValue(), unit.getClass());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}
