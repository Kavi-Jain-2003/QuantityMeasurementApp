package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
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

    // ---------- Arithmetic Operation Enum ----------

    private enum ArithmeticOperation {

        ADD {
            public double compute(double a, double b) {
                return a + b;
            }
        },

        SUBTRACT {
            public double compute(double a, double b) {
                return a - b;
            }
        },

        DIVIDE {
            public double compute(double a, double b) {
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
            }
        };

        public abstract double compute(double a, double b);
    }

    // ---------- Validation ----------

    private void validateArithmeticOperands(Quantity<U> other, String operation) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement categories");

        unit.validateOperationSupport(operation);
    }

    // ---------- Base Arithmetic ----------

    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation op) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return op.compute(base1, base2);
    }

    // ---------- ADD ----------

    public Quantity<U> add(Quantity<U> other) {

        validateArithmeticOperands(other, "addition");

        double result = performBaseArithmetic(other, ArithmeticOperation.ADD);

        double finalValue = unit.convertFromBaseUnit(result);

        return new Quantity<>(finalValue, unit);
    }

    // ---------- SUBTRACT ----------

    public Quantity<U> subtract(Quantity<U> other) {

        validateArithmeticOperands(other, "subtraction");

        double result = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double finalValue = unit.convertFromBaseUnit(result);

        return new Quantity<>(finalValue, unit);
    }

    // ---------- DIVIDE ----------

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, "division");

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    // ---------- CONVERSION ----------

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    // ---------- EQUALITY ----------

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public int hashCode() {

        double baseValue = unit.convertToBaseUnit(value);

        return Objects.hash(baseValue);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }}
