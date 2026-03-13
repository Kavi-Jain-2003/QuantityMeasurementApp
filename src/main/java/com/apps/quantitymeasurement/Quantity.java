package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // ---------------- EQUALITY ----------------

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    // ---------------- CONVERSION ----------------

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (!unit.getClass().getSimpleName()
                .equals(targetUnit.getClass().getSimpleName())) {

            throw new IllegalArgumentException("Cannot convert across categories");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(convertedValue, targetUnit);
    }


    // ---------------- ADD ----------------

    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("ADD");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double result = unit.convertFromBaseUnit(sum);

        return new Quantity<>(result, unit);
    }

    // ---------------- SUBTRACT ----------------

    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("SUBTRACT");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double diff = base1 - base2;

        double result = unit.convertFromBaseUnit(diff);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        unit.validateOperationSupport("SUBTRACT");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double diff = base1 - base2;

        double result = targetUnit.convertFromBaseUnit(diff);

        return new Quantity<>(result, targetUnit);
    }

    // ---------------- DIVIDE ----------------

    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("DIVIDE");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return base1 / base2;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
