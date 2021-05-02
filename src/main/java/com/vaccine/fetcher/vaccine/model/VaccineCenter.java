package com.vaccine.fetcher.vaccine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCenter {

  @JsonProperty("center_id")
  private String centerId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("state_name")
  private String state;

  @JsonProperty("district_name")
  private String district;

  @JsonProperty("block_name")
  private String block;

  @JsonProperty("pincode")
  private Integer pincode;

  @JsonProperty("lat")
  private Double dist_lat;

  @JsonProperty("long")
  private Double dist_long;

  @JsonProperty("from")
  private String from;

  @JsonProperty("to")
  private String to;

  @JsonProperty("fee_type")
  private String feeType;

  @JsonProperty("sessions")
  private List<VaccineSession> sessions;
}
