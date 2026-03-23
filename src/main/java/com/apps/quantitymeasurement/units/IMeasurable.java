package com.apps.quantitymeasurement.units;
@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {

	 double getConversionFactor();

	    double convertToBase(double value);

	    double convertFromBase(double value);
	    
	    String getUnitName();

	    default void validOperationSupport(String operation){}
}
