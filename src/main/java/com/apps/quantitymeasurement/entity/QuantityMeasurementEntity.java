package com.apps.quantitymeasurement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class QuantityMeasurementEntity implements Serializable {

    private long id;

    private double value1;
    private double value2;

    private String unit1;
    private String unit2;

    private String operationType;
    private String measurementType;

    private double result;

    private boolean error;

    private LocalDateTime timestamp;

    // Default Constructor (Required for JDBC / frameworks)
    public QuantityMeasurementEntity() {
    }

    // Parameterized Constructor
    public QuantityMeasurementEntity(String operationType, double value1, double value2,
                                     String unit1, String unit2, String measurementType,
                                     double result, boolean error) {
        this.operationType = operationType;
        this.value1 = value1;
        this.value2 = value2;
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.measurementType = measurementType;
        this.result = result;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

    // Getters

    public long getId() {
        return id;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public String getUnit1() {
        return unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public double getResult() {
        return result;
    }

    public boolean isError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
