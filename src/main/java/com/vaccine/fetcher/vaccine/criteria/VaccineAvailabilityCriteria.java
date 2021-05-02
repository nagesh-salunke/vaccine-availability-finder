package com.vaccine.fetcher.vaccine.criteria;

import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public interface VaccineAvailabilityCriteria {

  //return matching sessions for the criteria
  List<String> apply(VaccineCenter vaccineCenter);
}
