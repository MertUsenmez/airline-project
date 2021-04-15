package com.airline.airlineapp.dao;

import java.util.List;

public class CrudRequest {

  private String name;
  private String nation;
  private Integer passengerCapacity;
  private String foundation;
  private List<CompanyContact> companyContacts;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public Integer getPassengerCapacity() {
    return passengerCapacity;
  }

  public void setPassengerCapacity(Integer passengerCapacity) {
    this.passengerCapacity = passengerCapacity;
  }

  public String getFoundation() {
    return foundation;
  }

  public void setFoundation(String foundation) {
    this.foundation = foundation;
  }

  public List<CompanyContact> getCompanyContacts() {
    return companyContacts;
  }

  public void setCompanyContacts(List<CompanyContact> companyContacts) {
    this.companyContacts = companyContacts;
  }
}
