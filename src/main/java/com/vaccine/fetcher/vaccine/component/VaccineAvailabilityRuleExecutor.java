package com.vaccine.fetcher.vaccine.component;

import com.vaccine.fetcher.vaccine.model.AvailableVaccineSession;
import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public interface VaccineAvailabilityRuleExecutor {

  List<AvailableVaccineSession> execute(List<VaccineCenter> vaccineCenters);
}
