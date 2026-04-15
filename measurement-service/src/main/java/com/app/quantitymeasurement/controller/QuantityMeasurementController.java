package com.app.quantitymeasurement.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import com.app.quantitymeasurement.model.QuantityMeasurementDTO;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.model.QuantityModel;
import com.app.quantitymeasurement.unit.Quantity;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
@CrossOrigin(origins = "http://localhost:4200")
//@SecurityRequirement(name = "bearerAuth")

public class QuantityMeasurementController {

	@Autowired
	private com.app.quantitymeasurement.service.IQuantityMeasurementService service;

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
	@PostMapping("/multiply")
	public QuantityMeasurementEntity multiply(@RequestBody QuantityMeasurementDTO input) {
	    return service.multiply(getQ1(input), getQ2(input));
	}


	@PostMapping("/convert")
	public QuantityMeasurementEntity convert(@RequestBody QuantityMeasurementDTO input) {
		Quantity<?> q1 = getQ1(input);
		Quantity<?> q2 = getQ2(input);

		return service.convert(q1, q2);

	}

	@GetMapping("/test")
	public String test() {
		return "Service is running!";
	}
}