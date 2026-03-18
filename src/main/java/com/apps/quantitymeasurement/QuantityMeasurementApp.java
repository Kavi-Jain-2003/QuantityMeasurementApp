package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementCacheRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1, "FEET");
        QuantityDTO q2 = new QuantityDTO(12, "INCHES");

        controller.performAddition(q1, q2);

        System.out.println("Total Records Stored: " + repository.getTotalCount());
    }
}