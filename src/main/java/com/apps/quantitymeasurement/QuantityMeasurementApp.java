package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.service.*;
import com.apps.quantitymeasurement.units.LengthUnit;
import com.apps.quantitymeasurement.units.Quantity;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        QuantityMeasurementController controller = new QuantityMeasurementController(new QuantityMeasurementServiceImpl());

        Quantity<LengthUnit> length1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12, LengthUnit.INCH);

        controller.demonstrateEquality(length1, length2);
        controller.demonstrateAddition(length1, length2);
    }
}