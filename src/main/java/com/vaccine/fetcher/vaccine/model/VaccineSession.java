package com.vaccine.fetcher.vaccine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VaccineSession {

  @JsonProperty("session_id")
  private String sessionId;

  @JsonProperty("date")
  private String date;

  @JsonProperty("available_capacity")
  private Integer availableCapacity;

  @JsonProperty("min_age_limit")
  private Integer minAgeLimit;

  @JsonProperty("vaccine")
  private String vaccine;

  @JsonProperty("slots")
  private List<String> slots;
}
