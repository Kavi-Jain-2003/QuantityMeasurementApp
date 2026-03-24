
package com.apps.quantitymeasurement.repository;
import com.apps.quantitymeasurement.entity.*;
import java.util.*;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository{
    private final List<QuantityMeasurementEntity> storage = new ArrayList<>();

    @Override
    public void save(QuantityMeasurementEntity entity) {
        storage.add(entity);
    }
}
