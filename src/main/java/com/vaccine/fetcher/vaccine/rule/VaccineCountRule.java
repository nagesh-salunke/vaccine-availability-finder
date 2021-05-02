package com.vaccine.fetcher.vaccine.rule;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineCountRule implements VaccineAvailabilityRule {

  private Integer minAvailable;

  public VaccineCountRule(Integer minAvailable) {
    this.minAvailable = minAvailable;
  }

  @Override
  public List<String> execute(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return vaccineCenter.getSessions()
        .stream()
        .filter(k -> (k.getAvailableCapacity() >= minAvailable) )
        .map(VaccineSession::getSessionId)
        .collect(Collectors.toList());
  }
}
