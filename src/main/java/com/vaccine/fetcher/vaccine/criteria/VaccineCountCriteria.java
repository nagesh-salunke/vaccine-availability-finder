package com.vaccine.fetcher.vaccine.criteria;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineCountCriteria implements VaccineAvailabilityCriteria {

  private Integer minAvailable;

  public VaccineCountCriteria(Integer minAvailable) {
    this.minAvailable = minAvailable;
  }

  @Override
  public List<String> apply(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return vaccineCenter.getSessions()
        .stream()
        .filter(k -> (k.getAvailableCapacity() >= minAvailable) )
        .map(VaccineSession::getSessionId)
        .collect(Collectors.toList());
  }
}
