package com.app.quantitymeasurement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.quantitymeasurement.history.service.UserHistoryService;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.unit.IMeasurable;
import com.app.quantitymeasurement.unit.Quantity;
import org.springframework.security.core.context.SecurityContextHolder;

@SuppressWarnings("unchecked")
@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private UserHistoryService historyService;

    @Override
    public QuantityMeasurementEntity compare(Quantity<?> q1, Quantity<?> q2) {
        String input = q1.toString() + " vs " + q2.toString();

        try {
            boolean result = q1.equals(q2);

            // 🔥 SAVE HISTORY
            historyService.saveHistory(
                    "COMPARE",
                    input,
                    String.valueOf(result),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "COMPARE",
                    q1.toString(),
                    q2.toString(),
                    String.valueOf(result));

        } catch (Exception e) {

            historyService.saveHistory(
                    "COMPARE",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity convert(Quantity<?> quantity, Quantity<?> targetQuantity) {
        String input = quantity.toString() + " to " + targetQuantity.getUnit();

        try {
            Quantity<IMeasurable> q = (Quantity<IMeasurable>) quantity;
            Quantity<?> result = q.convertTo(targetQuantity.getUnit());

            // 🔥 SAVE HISTORY
            historyService.saveHistory(
                    "CONVERT",
                    input,
                    result.toString(),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "CONVERT",
                    quantity.toString(),
                    null,
                    result.toString()
            );

        } catch (Exception e) {

            historyService.saveHistory(
                    "CONVERT",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity add(Quantity<?> q1, Quantity<?> q2) {
        String input = q1.toString() + " + " + q2.toString();

        try {
            Quantity result = ((Quantity) q1).add((Quantity) q2);

            historyService.saveHistory(
                    "ADD",
                    input,
                    result.toString(),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "ADD",
                    q1.toString(),
                    q2.toString(),
                    result.toString());

        } catch (Exception e) {

            historyService.saveHistory(
                    "ADD",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity subtract(Quantity<?> q1, Quantity<?> q2) {
        String input = q1.toString() + " - " + q2.toString();

        try {
            Quantity result = ((Quantity) q1).subtract((Quantity) q2);

            historyService.saveHistory(
                    "SUBTRACT",
                    input,
                    result.toString(),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "SUBTRACT",
                    q1.toString(),
                    q2.toString(),
                    result.toString());

        } catch (Exception e) {

            historyService.saveHistory(
                    "SUBTRACT",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity multiply(Quantity<?> q1, Quantity<?> q2) {
        String input = q1.toString() + " * " + q2.toString();

        try {
            Quantity result = ((Quantity) q1).multiply((Quantity) q2);

            historyService.saveHistory(
                    "MULTIPLY",
                    input,
                    result.toString(),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "MULTIPLY",
                    q1.toString(),
                    q2.toString(),
                    result.toString());

        } catch (Exception e) {

            historyService.saveHistory(
                    "MULTIPLY",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    @Override
    public QuantityMeasurementEntity divide(Quantity<?> q1, Quantity<?> q2) {
        String input = q1.toString() + " / " + q2.toString();

        try {
            double result = ((Quantity) q1).divide((Quantity) q2);

            historyService.saveHistory(
                    "DIVIDE",
                    input,
                    String.valueOf(result),
                    "SUCCESS",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(
                    "DIVIDE",
                    q1.toString(),
                    q2.toString(),
                    String.valueOf(result));

        } catch (Exception e) {

            historyService.saveHistory(
                    "DIVIDE",
                    input,
                    "ERROR",
                    "FAILED",
                    getCurrentUsername()
            );

            return new QuantityMeasurementEntity(e.getMessage());
        }
    }

    public String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
