package com.airline.airlineapp.dao;

public class FligthSearchRequest {

  private String flightCode;
  private String airlineCompanyName;

  public String getFlightCode() {
    return flightCode;
  }

  public void setFlightCode(String flightCode) {
    this.flightCode = flightCode;
  }

  public String getAirlineCompanyName() {
    return airlineCompanyName;
  }

  public void setAirlineCompanyName(String airlineCompanyName) {
    this.airlineCompanyName = airlineCompanyName;
  }
}
