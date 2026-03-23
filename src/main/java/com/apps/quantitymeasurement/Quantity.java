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
    private double toBaseValue(){
        double base = unit.convertToBase(value);
        return Math.round(base * 100000.0) / 100000.0;
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

        double thisBase = this.toBaseValue();
        double otherBase = other.toBaseValue();

        double epsilon = 0.0001;

        return Math.abs(thisBase - otherBase) < epsilon;
    }

    public Quantity<U> convertTo(U targetUnit){
        if(targetUnit == null){ throw new IllegalArgumentException("Target unit cannot be null!");}
        double base = this.toBaseValue();
        double converted = targetUnit.convertFromBase(base);
        double rounded = Math.round(converted * 100.0)/ 100.0;

        return new Quantity<>(rounded, targetUnit);
    }
    
    /* Addition with implicit target unit (this unit) */
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    /* Addition with explicit target unit */
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisBase = this.toBaseValue();
        double otherBase = other.toBaseValue();

        double resultBase = thisBase + otherBase;

        double result = targetUnit.convertFromBase(resultBase);

        double rounded = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }


    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateQuantity(other);

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisBase = this.toBaseValue();
        double otherBase = other.toBaseValue();

        double resultBase = thisBase - otherBase;

        double result = targetUnit.convertFromBase(resultBase);


        double rounded = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    public double divide(Quantity<U> other) {

        validateQuantity(other);


        double thisBase = this.toBaseValue();
        double otherBase = other.toBaseValue();
        if (otherBase == 0)
            throw new ArithmeticException("Division by zero quantity");

        return thisBase / otherBase;
    }


    private void validateQuantity(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (Double.isNaN(other.value) || Double.isInfinite(other.value))
            throw new IllegalArgumentException("Invalid numeric value");
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}