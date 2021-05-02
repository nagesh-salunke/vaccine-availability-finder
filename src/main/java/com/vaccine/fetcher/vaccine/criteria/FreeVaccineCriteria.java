package com.vaccine.fetcher.vaccine.criteria;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FreeVaccineCriteria implements VaccineAvailabilityCriteria {

  private Boolean isFree;

  public FreeVaccineCriteria(Boolean isFree) {
    this.isFree = isFree;
  }

  @Override
  public List<String> apply(VaccineCenter vaccineCenter) {
    List<String> sessions =  new ArrayList<>();
    if(isFree) {
      if(vaccineCenter.getFeeType().equals("Free")) {
        sessions = vaccineCenter.getSessions().stream()
            .map(VaccineSession::getSessionId)
            .collect(Collectors.toList());
      }
    } else {
      if(vaccineCenter.getFeeType().equals("Paid")) {
        sessions = vaccineCenter.getSessions().stream()
            .map(VaccineSession::getSessionId)
            .collect(Collectors.toList());
      }
    }
    return sessions;
  }
}
