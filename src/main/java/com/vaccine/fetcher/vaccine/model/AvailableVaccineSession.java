package com.vaccine.fetcher.vaccine.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AvailableVaccineSession {

  private String centerId;

  private String name;

  private String state;

  private String district;

  private String block;

  private Integer pincode;

  private Double dist_lat;

  private Double dist_long;

  private String from;

  private String to;

  private String feeType;

  private List<VaccineSession> vaccineSession;

}
