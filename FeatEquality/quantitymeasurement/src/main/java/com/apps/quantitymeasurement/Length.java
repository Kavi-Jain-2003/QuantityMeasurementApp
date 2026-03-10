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

	    private double convertToBaseUnit() {
	        return value * unit.getConversionFactor();
	    }

	    @Override
	    public boolean equals(Object obj) {

	        if (this == obj)
	            return true;

	        if (obj == null || getClass() != obj.getClass())
	            return false;

	        Length other = (Length) obj;

	        return Double.compare(this.convertToBaseUnit(),
	                              other.convertToBaseUnit()) == 0;
	    }

	    @Override
	    public int hashCode() {
	        return Double.hashCode(convertToBaseUnit());
	    }
}
