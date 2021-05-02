package com.vaccine.fetcher.vaccine.component;

import com.vaccine.fetcher.vaccine.config.VaccineCriteriaConfig;
import com.vaccine.fetcher.vaccine.model.AvailableVaccineSession;
import com.vaccine.fetcher.vaccine.model.VaccineCenter;
import com.vaccine.fetcher.vaccine.model.VaccineSession;
import com.vaccine.fetcher.vaccine.criteria.VaccineAvailabilityCriteria;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class CowinVaccineAvailabilityEngine implements VaccineAvailabilityEngine {

  @Resource
  private VaccineCriteriaConfig vaccineCriteriaConfig;

  @Override
  public List<AvailableVaccineSession> findSessions(List<VaccineCenter> vaccineCenters) {

    List<VaccineAvailabilityCriteria> vaccineCriteria = vaccineCriteriaConfig.findVaccineCriteria();

    //for each center identify all sessions that match "all" rules
    List<AvailableVaccineSession> availableVaccineSessions = new ArrayList<>();

    for(VaccineCenter vaccineCenter : vaccineCenters) {
      Set<String> matchingSessions = new HashSet<>();
      for(VaccineAvailabilityCriteria criteria : vaccineCriteria) {
        List<String> results = criteria.apply(vaccineCenter);
        if(matchingSessions.size() == 0) {
          matchingSessions.addAll(results);
        } else {
          matchingSessions.retainAll(results);
        }
      }
      if(matchingSessions.size() !=0 ) {
        availableVaccineSessions.add(mapToVaccineSession(vaccineCenter, matchingSessions));
      }
    }
    return availableVaccineSessions;
  }

  private AvailableVaccineSession mapToVaccineSession(
      VaccineCenter vaccineCenter, Set<String> matchingSessions) {
    AvailableVaccineSession availableVaccineSession = new AvailableVaccineSession();

    availableVaccineSession.setCenterId(vaccineCenter.getCenterId());
    availableVaccineSession.setName(vaccineCenter.getName());
    availableVaccineSession.setBlock(vaccineCenter.getBlock());
    availableVaccineSession.setDist_lat(vaccineCenter.getDist_lat());
    availableVaccineSession.setDist_long(vaccineCenter.getDist_long());
    availableVaccineSession.setFeeType(vaccineCenter.getFeeType());
    availableVaccineSession.setPincode(vaccineCenter.getPincode());
    availableVaccineSession.setFrom(vaccineCenter.getFrom());
    availableVaccineSession.setTo(vaccineCenter.getTo());
    availableVaccineSession.setState(vaccineCenter.getState());
    availableVaccineSession.setDistrict(vaccineCenter.getDistrict());

    Map<String, VaccineSession> vaccineSessionMap = vaccineCenter.getSessions().stream()
        .collect(Collectors.toMap(VaccineSession::getSessionId, Function.identity()));

    List<VaccineSession> vaccineSessions = new ArrayList<>();
    for(String s: matchingSessions) {
      VaccineSession vaccineSession = vaccineSessionMap.get(s);
      vaccineSessions.add(vaccineSession);
    }
    availableVaccineSession.setVaccineSession(vaccineSessions);
    return availableVaccineSession;
  }
}
