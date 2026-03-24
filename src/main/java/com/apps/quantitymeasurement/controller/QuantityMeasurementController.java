
package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.entity.*;
import com.apps.quantitymeasurement.unit.*;
import com.apps.quantitymeasurement.service.*;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        if(service == null)
            throw new IllegalArgumentException("Service cannot be null");

        this.service = service;
    }

    public void displayResult(QuantityMeasurementEntity entity) {
        if(entity.hasError())
            System.out.println("ERROR: " + entity.getError());
        
        else 
            System.out.println(entity.toString());
    }

    public void demonstrateEquality(Quantity<?> q1, Quantity<?> q2) {
        QuantityMeasurementEntity result = service.compare(q1, q2);

        displayResult(result);
    }

    public void demonstrateConversion(Quantity<?> quantity, Object targetUnit) {

        QuantityMeasurementEntity result = service.convert(quantity, targetUnit);

        displayResult(result);
    }

    public void demonstrateAddition(Quantity<?> q1, Quantity<?> q2) {

        QuantityMeasurementEntity result = service.add(q1, q2);

        displayResult(result);
    }
}
