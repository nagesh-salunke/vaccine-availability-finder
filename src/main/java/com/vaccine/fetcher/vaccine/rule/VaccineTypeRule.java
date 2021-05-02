package com.vaccine.fetcher.vaccine.rule;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public class VaccineTypeRule implements VaccineAvailabilityRule {

  private String type;

  public VaccineTypeRule(String type) {
    this.type = type;
  }

  @Override
  public List<String> execute(VaccineCenter vaccineCenter) {
    //apply type on the center and return matching
    return null;
  }
}
