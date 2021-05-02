package com.vaccine.fetcher.vaccine.rule;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineAgeRule implements VaccineAvailabilityRule {

  private Integer minAge;

  public VaccineAgeRule(Integer minAge) {
    this.minAge = minAge;
  }

  @Override
  public List<String> execute(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return vaccineCenter.getSessions()
        .stream()
        .filter(k -> (k.getMinAgeLimit() <= minAge) )
        .map(VaccineSession::getSessionId)
        .collect(Collectors.toList());
  }
}
