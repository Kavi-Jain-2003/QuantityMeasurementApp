package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.*;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurement.unit.LengthUnit;
import com.apps.quantitymeasurement.unit.Quantity;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    // ---------------- COMPARE ----------------

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return quantity1.equals(quantity2);
    }

    // ---------------- CONVERT ----------------

    @Override
    public QuantityDTO convert(QuantityDTO quantity, String targetUnit) {

        Quantity<LengthUnit> q =
                new Quantity<>(quantity.getValue(), LengthUnit.valueOf(quantity.getUnit()));

        Quantity<LengthUnit> result =
                q.convertTo(LengthUnit.valueOf(targetUnit));

        return new QuantityDTO(result.getValue(), result.getUnit().name());
    }

    // ---------------- ADD ----------------

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        Quantity<LengthUnit> result = quantity1.add(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().name());
    }

    // ---------------- SUBTRACT ----------------

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        Quantity<LengthUnit> result = quantity1.subtract(quantity2);

        return new QuantityDTO(result.getValue(), result.getUnit().name());
    }

    // ---------------- DIVIDE ----------------

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        Quantity<LengthUnit> quantity1 =
                new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

        Quantity<LengthUnit> quantity2 =
                new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

        return quantity1.divide(quantity2);
    }
}
