package com.iptech.dreamhousingloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class DreamHousingLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamHousingLoanApplication.class, args);
	}

}
