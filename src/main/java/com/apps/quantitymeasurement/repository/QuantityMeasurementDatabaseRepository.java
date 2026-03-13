package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.exception.DatabaseException;
import com.apps.quantitymeasurement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    private final ConnectionPool connectionPool;

    public QuantityMeasurementDatabaseRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = "INSERT INTO quantity_measurement_entity " +
                "(operation_type, measurement_type, value1, value2, result) " +
                "VALUES (?, ?, ?, ?, ?)";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, entity.getOperationType());
            stmt.setString(2, entity.getMeasurementType());
            stmt.setDouble(3, entity.getValue1());
            stmt.setDouble(4, entity.getValue2());
            stmt.setDouble(5, entity.getResult());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error saving entity", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM quantity_measurement_entity";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

                entity.setId(rs.getLong("id"));
                entity.setOperationType(rs.getString("operation_type"));
                entity.setMeasurementType(rs.getString("measurement_type"));
                entity.setValue1(rs.getDouble("value1"));
                entity.setValue2(rs.getDouble("value2"));
                entity.setResult(rs.getDouble("result"));

                list.add(entity);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error fetching data", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return list;
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByOperation(String operationType) {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM quantity_measurement_entity WHERE operation_type=?";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, operationType);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

                entity.setId(rs.getLong("id"));
                entity.setOperationType(rs.getString("operation_type"));
                entity.setMeasurementType(rs.getString("measurement_type"));
                entity.setValue1(rs.getDouble("value1"));
                entity.setValue2(rs.getDouble("value2"));
                entity.setResult(rs.getDouble("result"));

                list.add(entity);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error fetching by operation", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return list;
    }

    @Override
    public List<QuantityMeasurementEntity> getMeasurementsByType(String measurementType) {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM quantity_measurement_entity WHERE measurement_type=?";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, measurementType);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

                entity.setId(rs.getLong("id"));
                entity.setOperationType(rs.getString("operation_type"));
                entity.setMeasurementType(rs.getString("measurement_type"));
                entity.setValue1(rs.getDouble("value1"));
                entity.setValue2(rs.getDouble("value2"));
                entity.setResult(rs.getDouble("result"));

                list.add(entity);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error fetching by type", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return list;
    }

    @Override
    public int getTotalCount() {

        String sql = "SELECT COUNT(*) FROM quantity_measurement_entity";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error counting records", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return 0;
    }

    @Override
    public void deleteAll() {

        String sql = "DELETE FROM quantity_measurement_entity";

        Connection connection = connectionPool.getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting records", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public String getPoolStatistics() {
        return "Database repository using connection pool";
    }

    @Override
    public void releaseResources() {
        // could close pool connections here
    }
}
