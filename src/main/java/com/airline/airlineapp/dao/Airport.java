package com.airline.airlineapp.dao;

import com.airline.airlineapp.model.CompanyContactEntity;

public class Airport {

  private Long airportId;
  private String airportName;
  private CompanyContact contact;

  public Long getAirportId() {
    return airportId;
  }

  public void setAirportId(Long airportId) {
    this.airportId = airportId;
  }

  public String getAirportName() {
    return airportName;
  }

  public void setAirportName(String airportName) {
    this.airportName = airportName;
  }

  public CompanyContact getContact() {
    return contact;
  }

  public void setContact(CompanyContact contact) {
    this.contact = contact;
  }
}
