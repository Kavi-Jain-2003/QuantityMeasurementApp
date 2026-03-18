package com.apps.quantitymeasurement.service;
import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.unit.Quantity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(Quantity<?> quantity1, Quantity<?> quantity2);
    QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit);
    QuantityMeasurementEntity add(Quantity<?> quantity1, Quantity<?> quantity2);
    QuantityMeasurementEntity subtract(Quantity<?> quantity1, Quantity<?> quantity2);
    QuantityMeasurementEntity divide(Quantity<?> quantity1, Quantity<?> quantity2);
}