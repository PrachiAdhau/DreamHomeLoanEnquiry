package com.iptech.dreamhousingloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@SpringBootApplication
public class DreamHousingLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamHousingLoanApplication.class, args);
	}
	@Bean
	public RestTemplate rt()
	{
		RestTemplate rt=new RestTemplate();
		return rt;
	}

}
