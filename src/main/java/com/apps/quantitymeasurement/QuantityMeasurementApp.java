package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.*;
import com.apps.quantitymeasurement.repository.*;
import com.apps.quantitymeasurement.service.*;
import com.apps.quantitymeasurement.unit.*;


public class QuantityMeasurementApp {
    public static void main(String[] args) {
        IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();
        
        QuantityMeasurementController controller = new QuantityMeasurementController(new QuantityMeasurementServiceImpl());

        Quantity<LengthUnit> length1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12, LengthUnit.INCH);

        controller.demonstrateEquality(length1, length2);
        controller.demonstrateAddition(length1, length2);
    }
}
