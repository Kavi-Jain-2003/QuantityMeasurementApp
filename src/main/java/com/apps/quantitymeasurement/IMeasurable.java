package com.apps.quantitymeasurement;

@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {

    // Mandatory methods (already implemented by enums)
    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double value);

    // Default lambda: arithmetic supported
    SupportsArithmetic supportsArithmetic = () -> true;

    // Default method
    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Default validation method
    default void validateOperationSupport(String operation) {
        // Do nothing by default
    }
}
