package com.vaccine.fetcher.vaccine.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetVaccineAvailabilityResponse {

  private List<VaccineCenter> centers;
}
