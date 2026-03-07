package com.apps.quantitymeasurement;

import java.util.Objects;

public class QuantityLength {

	private final double value;
	private final LengthUnit unit;
	private static final double EPSILON = 0.0001;

	public QuantityLength(double value, LengthUnit unit) {

		if (unit == null)
			throw new IllegalArgumentException("Unit cannot be null");
		 if (!Double.isFinite(value))
		        throw new IllegalArgumentException("Invalid value");

		this.value = value;
		this.unit = unit;
	}

	private double toFeet() {
		return unit.toFeet(value);
	}
	public double getValue() {
	    return value;
	}

	public LengthUnit getUnit() {
	    return unit;
	}

	@Override
	public boolean equals(Object obj) {

		// Reflexive
		if (this == obj)
			return true;

		// Null check
		if (obj == null)
			return false;

		// Type check
		if (getClass() != obj.getClass())
			return false;

		QuantityLength other = (QuantityLength) obj;

		return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
	}

	@Override
	public int hashCode() {
		return Objects.hash(toFeet());
	}
	@Override
	public String toString() {
	    return "Quantity(" + value + ", " + unit + ")";
	}


	public static double convert(double value, LengthUnit source, LengthUnit target) {

		if (!Double.isFinite(value))
			throw new IllegalArgumentException("Invalid numeric value");

		if (source == null || target == null)
			throw new IllegalArgumentException("Unit cannot be null");

// Step 1: convert to base unit (feet)
		double valueInFeet = source.toFeet(value);

// Step 2: convert from feet to target
		return target.fromFeet(valueInFeet);
	}
	public QuantityLength add(QuantityLength other) {

	    if (other == null)
	        throw new IllegalArgumentException("Second operand cannot be null");

//	    // convert both to feet
//	    double thisFeet = this.unit.toFeet(this.value);
//	    double otherFeet = other.unit.toFeet(other.value);
//
//	    // add values
//	    double sumFeet = thisFeet + otherFeet;

	    // convert back to first operand unit
//	    double result = this.unit.fromFeet(sumFeet);

//	    return new QuantityLength(result, this.unit);
	    return addInternal(other, this.unit);
	}
	private QuantityLength addInternal(QuantityLength other, LengthUnit targetUnit) {

	    // convert both to base unit (FEET)
	    double thisFeet = this.unit.toFeet(this.value);
	    double otherFeet = other.unit.toFeet(other.value);

	    // add
	    double sumFeet = thisFeet + otherFeet;

	    // convert to target unit
	    double result = targetUnit.fromFeet(sumFeet);

	    return new QuantityLength(result, targetUnit);
	}

	// UC7 METHOD (Overloaded add with target unit)
	public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

	    if (other == null)
	        throw new IllegalArgumentException("Second operand cannot be null");

	    if (targetUnit == null)
	        throw new IllegalArgumentException("Target unit cannot be null");

	    return addInternal(other, targetUnit);
	}



}
