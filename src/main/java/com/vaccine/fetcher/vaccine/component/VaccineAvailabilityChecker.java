package com.vaccine.fetcher.vaccine.component;

import com.vaccine.fetcher.vaccine.config.VaccineCriteriaConfig;
import com.vaccine.fetcher.vaccine.model.AvailableVaccineSession;
import com.vaccine.fetcher.vaccine.model.GetVaccineAvailabilityResponse;
import com.vaccine.fetcher.vaccine.repository.CowinRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VaccineAvailabilityChecker {

  private static final Logger logger = LoggerFactory.getLogger(VaccineAvailabilityChecker.class);

  @Value("#{'${vaccine.pincodes}'.split(',')}")
  private List<Integer> pinCodes;

  @Resource
  private VaccineCriteriaConfig vaccineCriteriaConfig;

  @Resource
  private CowinRepository cowinRepository;

  @Resource
  private VaccineAvailabilityEngine vaccineAvailabilityEngine;

  //query every minute
  @Scheduled(fixedRateString = "60000")
  public void checkVaccineInformation() {
    logger.info("Querying vaccine availability for provided criteria");
    logger.info("Vaccine cost {}, type {}, minAge {}, pin-codes {} ", vaccineCriteriaConfig.getVaccineCost(),
        vaccineCriteriaConfig.getVaccineType(), vaccineCriteriaConfig.getVaccineMinAge(), pinCodes);
    for(Integer pinCode : pinCodes) {
      //Query for all pinCodes
      List<String> datesToQuery = getDatesToQuery();
      List<AvailableVaccineSession> availableVaccineSessions = new ArrayList<>();
      for(String date : datesToQuery) {
        GetVaccineAvailabilityResponse availabilityResponse = cowinRepository
            .queryVaccineAvailability(pinCode, date);

        availableVaccineSessions.addAll(vaccineAvailabilityEngine.findSessions(availabilityResponse.getCenters()));
      }
      logger.info("For pincode {} below are the sessions as per your criteria {}", pinCode,
          availableVaccineSessions);
      //use available session to notify about the availability
    }
  }

  //4 weeks
  private List<String> getDatesToQuery() {
    List<String> datesToQuery = new ArrayList<>();
    LocalDate today = LocalDate.now();;
    datesToQuery.add(getFormattedDate(today));
    datesToQuery.add(getFormattedDate(today.plus(1, ChronoUnit.WEEKS)));
    datesToQuery.add(getFormattedDate(today.plus(2, ChronoUnit.WEEKS)));
    datesToQuery.add(getFormattedDate(today.plus(3, ChronoUnit.WEEKS)));
    return datesToQuery;
  }

  private String getFormattedDate(LocalDate today) {
    return today.getDayOfMonth() +"-"+today.getMonthValue()+"-"+today.getYear();
  }


}
