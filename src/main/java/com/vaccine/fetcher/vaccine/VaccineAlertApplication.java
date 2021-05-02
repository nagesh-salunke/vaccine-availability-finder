package com.vaccine.fetcher.vaccine;

import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccineAlertApplication {

	@Resource
	private VaccineAvailabilityFetcher vaccineAvailabilityFetcher;

	public static void main(String[] args) {
		SpringApplication.run(VaccineAlertApplication.class, args);
	}

}
