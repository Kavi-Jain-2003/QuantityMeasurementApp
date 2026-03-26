package com.apps.quantitymeasurement;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication

public class QuantityMeasurementAppApplication {

	public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("r@123"));
		SpringApplication.run(QuantityMeasurementAppApplication.class, args);
	}

}
