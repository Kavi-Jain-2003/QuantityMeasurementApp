package com.apps.quantitymeasurement;

public interface IMeasurable {

    // Returns the conversion factor relative to the base unit
    double getConversionFactor();

    // Convert value in this unit to base unit
    double convertToBaseUnit(double value);

    // Convert value from base unit to this unit
    double convertFromBaseUnit(double baseValue);

    // Returns a readable unit name
    String getUnitName();
}
