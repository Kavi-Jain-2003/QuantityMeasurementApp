package com.apps.quantitymeasurement.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.util.ConnectionPool;

public class QuantityMeasurementDatabaseRespositoryTest {
	@Test
	void shouldSaveMeasurementToDatabase() {

	    ConnectionPool pool = new ConnectionPool();
	    QuantityMeasurementDatabaseRepository repo =
	            new QuantityMeasurementDatabaseRepository(pool);

	    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

	    entity.setOperationType("COMPARE");
	    entity.setMeasurementType("LENGTH");
	    entity.setValue1(10);
	    entity.setValue2(1000);
	    entity.setResult(1);

	    repo.save(entity);

	    assertTrue(repo.getTotalCount() > 0);
	}

}
