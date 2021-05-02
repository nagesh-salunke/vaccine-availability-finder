package com.vaccine.fetcher.vaccine.criteria;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import java.util.List;
import java.util.stream.Collectors;

public class VaccineTypeCriteria implements VaccineAvailabilityCriteria {

  private String type;

  public VaccineTypeCriteria(String type) {
    this.type = type;
  }

  @Override
  public List<String> apply(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return vaccineCenter.getSessions()
        .stream()
        .filter(k -> type.equals(k))
        .map(VaccineSession::getSessionId)
        .collect(Collectors.toList());
  }
}
