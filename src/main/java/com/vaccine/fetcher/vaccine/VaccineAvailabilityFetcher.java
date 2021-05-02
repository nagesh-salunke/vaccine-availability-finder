package com.vaccine.fetcher.vaccine;

import com.vaccine.fetcher.vaccine.model.GetVaccineAvailabilityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VaccineAvailabilityFetcher {

  private static final Logger logger = LoggerFactory.getLogger(VaccineAvailabilityFetcher.class);

  private final String pinCode = "411045";

  @Scheduled(fixedRateString = "10000")
  public void fetchVaccineInformation() {
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=411045&date=02-05-2021";
    GetVaccineAvailabilityResponse availabilityResponse = restTemplate
        .getForObject(resourceUrl, GetVaccineAvailabilityResponse.class);
    logger.info("Vaccine List {}", availabilityResponse);
  }
}
