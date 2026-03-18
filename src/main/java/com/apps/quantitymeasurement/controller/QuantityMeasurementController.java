
package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.model.QuantityDTO;
import com.apps.quantitymeasurement.model.QuantityMeasurementDTO;
import com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.unit.Quantity;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.unit.LengthUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityMeasurementDTO input) {

        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.compare(q1, q2);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityMeasurementDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.add(q1, q2);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityMeasurementDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.subtract(q1, q2);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityMeasurementDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.convert(q1, q2);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityMeasurementDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.divide(q1, q2);
    }
}
