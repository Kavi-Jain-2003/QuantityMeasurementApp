package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.model.QuantityMeasurementDTO;

import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.model.QuantityModel;
import com.apps.quantitymeasurement.unit.Quantity;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    private Quantity<?> getQ1(QuantityMeasurementDTO input) {
        return QuantityModel.toQuantity(input.getThisQuantityDTO());
    }

    private Quantity<?> getQ2(QuantityMeasurementDTO input) {
        return QuantityModel.toQuantity(input.getThatQuantityDTO());
    }

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityMeasurementDTO input) {
        return service.compare(getQ1(input), getQ2(input));
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityMeasurementDTO input) {
        return service.add(getQ1(input), getQ2(input));
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityMeasurementDTO input) {
        return service.subtract(getQ1(input), getQ2(input));
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityMeasurementDTO input) {
        return service.divide(getQ1(input), getQ2(input));
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityMeasurementDTO input) {
        Quantity<?> q1 = getQ1(input);
        Quantity<?> q2 = getQ2(input);

        return service.convert(q1, q2.getUnit()); // 🔥 correct fix
    }
}
