package com.vaccine.fetcher.vaccine.repository;

import com.vaccine.fetcher.vaccine.model.GetVaccineAvailabilityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CowinRepository {

  private static final Logger logger = LoggerFactory.getLogger(CowinRepository.class);

  @Value("${cowin.availability.baseUrl}")
  private String cowinAvlURL;

  public GetVaccineAvailabilityResponse queryVaccineAvailability(Integer pinCode, String date) {
    RestTemplate restTemplate = new RestTemplate();
      //Query for all pinCodes
    String resourceUrl = cowinAvlURL + "pincode="+pinCode+"&date="+date;
    GetVaccineAvailabilityResponse availabilityResponse = restTemplate
        .getForObject(resourceUrl, GetVaccineAvailabilityResponse.class);
    logger.info("Vaccine List for {} is {}", pinCode, availabilityResponse);
    return availabilityResponse;
  }
}
