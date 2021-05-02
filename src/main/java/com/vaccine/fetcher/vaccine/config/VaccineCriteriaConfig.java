package com.vaccine.fetcher.vaccine.config;

import com.vaccine.fetcher.vaccine.criteria.FreeVaccineCriteria;
import com.vaccine.fetcher.vaccine.criteria.VaccineAgeCriteria;
import com.vaccine.fetcher.vaccine.criteria.VaccineAvailabilityCriteria;
import com.vaccine.fetcher.vaccine.criteria.VaccineCountCriteria;
import com.vaccine.fetcher.vaccine.criteria.VaccineTypeCriteria;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Data
@Configuration
public class VaccineCriteriaConfig {

  @Value("${vaccine.type}")
  private String vaccineType;

  @Value("${vaccine.cost}")
  private String vaccineCost;

  @Value("${vaccine.minAge}")
  private Integer vaccineMinAge;

  public List<VaccineAvailabilityCriteria> findVaccineCriteria() {
    List<VaccineAvailabilityCriteria> rules = new ArrayList<>();

    if(StringUtils.hasText(vaccineType)) {
      if(vaccineType.equals("COVAXIN") || vaccineType.equals("COVISHIELD")) {
       rules.add(new VaccineTypeCriteria(vaccineType));
      }
    }
    if(StringUtils.hasText(vaccineCost)) {
      if(vaccineCost.equals("FREE")) {
        rules.add(new FreeVaccineCriteria(true));
      } else if(vaccineCost.equals("PAID")) {
        rules.add(new FreeVaccineCriteria(false));
      }
    }

    rules.add(new VaccineAgeCriteria(vaccineMinAge));
    rules.add(new VaccineCountCriteria(1));
    return rules;
  }
}
