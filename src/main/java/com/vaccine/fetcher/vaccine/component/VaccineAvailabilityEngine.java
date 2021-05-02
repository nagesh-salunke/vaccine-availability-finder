package com.vaccine.fetcher.vaccine.component;

import com.vaccine.fetcher.vaccine.model.AvailableVaccineSession;
import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import java.util.List;

public interface VaccineAvailabilityEngine {

  List<AvailableVaccineSession> findSessions(List<VaccineCenter> vaccineCenters);
}
