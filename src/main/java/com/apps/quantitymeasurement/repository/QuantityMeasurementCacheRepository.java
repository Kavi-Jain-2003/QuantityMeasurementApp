package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    private static QuantityMeasurementCacheRepository instance;

    private List<QuantityMeasurementEntity> cache = new ArrayList<>();

    private QuantityMeasurementCacheRepository() {}

    public static QuantityMeasurementCacheRepository getInstance() {

        if (instance == null)
            instance = new QuantityMeasurementCacheRepository();

        return instance;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        cache.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return new ArrayList<>(cache);
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByOperation(String operationType) {

        return cache.stream()
                .filter(e -> e.getOperationType().equalsIgnoreCase(operationType))
                .collect(Collectors.toList());
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(String measurementType) {

        return cache.stream()
                .filter(e -> e.getMeasurementType().equalsIgnoreCase(measurementType))
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalCount() {
        return cache.size();
    }

    @Override
    public void deleteAll() {
        cache.clear();
    }

    @Override
    public String getPoolStatistics() {
        return "Cache repository - no connection pool";
    }

    @Override
    public void releaseResources() {
        cache.clear();
    }
}
