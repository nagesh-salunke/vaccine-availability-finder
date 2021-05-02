package com.vaccine.fetcher.vaccine.criteria;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public class VaccineTypeCriteria implements VaccineAvailabilityCriteria {

  private String type;

  public VaccineTypeCriteria(String type) {
    this.type = type;
  }

  @Override
  public List<String> apply(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return null;
  }
}
