package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    // Save a measurement entity
    void save(QuantityMeasurementEntity entity);

    // Retrieve all measurements
    List<QuantityMeasurementEntity> getAllMeasurements();

    // Retrieve measurements by operation type
    List<QuantityMeasurementEntity> getMeasurementsByOperation(String operationType);

    // Retrieve measurements by measurement type
    List<QuantityMeasurementEntity> getMeasurementsByType(String measurementType);

    // Get total number of measurements stored
    int getTotalCount();

    // Delete all measurements
    void deleteAll();

    // Default method for connection pool statistics
    default String getPoolStatistics() {
        return "Connection Pool statistics not available.";
    }

    // Default method for releasing resources
    default void releaseResources() {
        // Optional implementation
    }
}
