package com.vaccine.fetcher.vaccine.config;

import com.vaccine.fetcher.vaccine.rule.FreeVaccineRule;
import com.vaccine.fetcher.vaccine.rule.VaccineAgeRule;
import com.vaccine.fetcher.vaccine.rule.VaccineAvailabilityRule;
import com.vaccine.fetcher.vaccine.rule.VaccineCountRule;
import com.vaccine.fetcher.vaccine.rule.VaccineTypeRule;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Data
@Configuration
public class VaccineRuleConfig {

  @Value("${vaccine.type}")
  private String vaccineType;

  @Value("${vaccine.cost}")
  private String vaccineCost;

  @Value("${vaccine.minAge}")
  private Integer vaccineMinAge;

  public List<VaccineAvailabilityRule> findVaccineRules() {
    List<VaccineAvailabilityRule> rules = new ArrayList<>();

    if(StringUtils.hasText(vaccineType)) {
      if(vaccineType.equals("COVAXIN") || vaccineType.equals("COVISHIELD")) {
       rules.add(new VaccineTypeRule(vaccineType));
      }
    }
    if(StringUtils.hasText(vaccineCost)) {
      if(vaccineCost.equals("FREE")) {
        rules.add(new FreeVaccineRule(true));
      } else if(vaccineCost.equals("PAID")) {
        rules.add(new FreeVaccineRule(false));
      }
    }

    rules.add(new VaccineAgeRule(vaccineMinAge));
    rules.add(new VaccineCountRule(1));
    return rules;
  }
}
