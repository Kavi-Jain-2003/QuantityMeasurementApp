CREATE TABLE IF NOT EXISTS quantity_measurement_entity (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    operation_type VARCHAR(50),
    measurement_type VARCHAR(50),

    value1 DOUBLE,
    value2 DOUBLE,

    unit1 VARCHAR(20),
    unit2 VARCHAR(20),

    result DOUBLE,

    error BOOLEAN,

    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
