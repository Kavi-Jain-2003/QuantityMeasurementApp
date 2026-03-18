package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.exception.QuantityMeasurementException;
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
        try {
            Quantity<LengthUnit> quantity1 =
                    new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

            Quantity<LengthUnit> quantity2 =
                    new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

            return quantity1.equals(quantity2);

        } catch (Exception e) {
            throw new QuantityMeasurementException("Comparison failed: " + e.getMessage());
        }
    }

    // ---------------- CONVERT ----------------
    @Override
    public QuantityDTO convert(QuantityDTO quantity, String targetUnit) {

        try {
            Quantity<LengthUnit> q =
                    new Quantity<>(quantity.getValue(), LengthUnit.valueOf(quantity.getUnit()));

            Quantity<LengthUnit> result =
                    q.convertTo(LengthUnit.valueOf(targetUnit));

            saveEntity("CONVERT", quantity, null, result.getValue(), false);

            return new QuantityDTO(result.getValue(), result.getUnit().name());

        } catch (Exception e) {
            saveEntity("CONVERT", quantity, null, 0, true);
            throw new QuantityMeasurementException("Conversion failed: " + e.getMessage());
        }
    }

    // ---------------- ADD ----------------
    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        try {
            Quantity<LengthUnit> quantity1 =
                    new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

            Quantity<LengthUnit> quantity2 =
                    new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

            Quantity<LengthUnit> result = quantity1.add(quantity2);

            saveEntity("ADD", q1, q2, result.getValue(), false);

            return new QuantityDTO(result.getValue(), result.getUnit().name());

        } catch (Exception e) {
            saveEntity("ADD", q1, q2, 0, true);
            throw new QuantityMeasurementException("Addition failed: " + e.getMessage());
        }
    }

    // ---------------- SUBTRACT ----------------
    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        try {
            Quantity<LengthUnit> quantity1 =
                    new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

            Quantity<LengthUnit> quantity2 =
                    new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

            Quantity<LengthUnit> result = quantity1.subtract(quantity2);

            saveEntity("SUBTRACT", q1, q2, result.getValue(), false);

            return new QuantityDTO(result.getValue(), result.getUnit().name());

        } catch (Exception e) {
            saveEntity("SUBTRACT", q1, q2, 0, true);
            throw new QuantityMeasurementException("Subtraction failed: " + e.getMessage());
        }
    }

    // ---------------- DIVIDE ----------------
    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        try {
            Quantity<LengthUnit> quantity1 =
                    new Quantity<>(q1.getValue(), LengthUnit.valueOf(q1.getUnit()));

            Quantity<LengthUnit> quantity2 =
                    new Quantity<>(q2.getValue(), LengthUnit.valueOf(q2.getUnit()));

            double result = quantity1.divide(quantity2);

            saveEntity("DIVIDE", q1, q2, result, false);

            return result;

        } catch (Exception e) {
            saveEntity("DIVIDE", q1, q2, 0, true);
            throw new QuantityMeasurementException("Division failed: " + e.getMessage());
        }
    }

    // ---------------- COMMON SAVE METHOD ----------------
    private void saveEntity(String operation,
                           QuantityDTO q1,
                           QuantityDTO q2,
                           double result,
                           boolean error) {

        QuantityMeasurementEntity entity = new QuantityMeasurementEntity(
                operation,
                q1 != null ? q1.getValue() : 0,
                q2 != null ? q2.getValue() : 0,
                q1 != null ? q1.getUnit() : null,
                q2 != null ? q2.getUnit() : null,
                "LENGTH", // can be enhanced dynamically
                result,
                error
        );

        repository.save(entity);
    }
}