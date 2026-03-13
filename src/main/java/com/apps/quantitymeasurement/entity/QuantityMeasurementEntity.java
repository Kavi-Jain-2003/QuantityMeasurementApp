package com.apps.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private double value1;
    private double value2;
    private String unit1;
    private String unit2;
    private String operation;
    private String result;
    private boolean error;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public boolean hasError() {
        return error;
    }
}
