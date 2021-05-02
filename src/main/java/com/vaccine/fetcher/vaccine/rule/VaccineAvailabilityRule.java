package com.vaccine.fetcher.vaccine.rule;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public interface VaccineAvailabilityRule {

  //return matching sessions for the rule
  List<String> execute(VaccineCenter vaccineCenter);
}
