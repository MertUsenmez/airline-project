package com.airline.airlineapp.dao;

import java.util.ArrayList;
import java.util.List;

public class AirlineCompany {

  private Long airlineCompanyId;
  private String companyName;
  private int passengerCapacity;
  private String nation;
  private List<CompanyContact> companyContacts = new ArrayList<>();


  public Long getAirlineCompanyId() {
    return airlineCompanyId;
  }

  public void setAirlineCompanyId(Long airlineCompanyId) {
    this.airlineCompanyId = airlineCompanyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public int getPassengerCapacity() {
    return passengerCapacity;
  }

  public void setPassengerCapacity(int passengerCapacity) {
    this.passengerCapacity = passengerCapacity;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public List<CompanyContact> getCompanyContacts() {
    return companyContacts;
  }

  public void setCompanyContacts(List<CompanyContact> companyContacts) {
    this.companyContacts = companyContacts;
  }
}
