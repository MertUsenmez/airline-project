package com.airline.airlineapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="airline_company")
public class AirlineCompanyEntity {

  private Long airlineCompanyId;
  private String companyName;
  private int passengerCapacity;
  private String nation;

  //relation
  private List<CompanyContactEntity> companyContactList = new ArrayList<>();
  private List<FlightEntity> flightEntityList = new ArrayList<>();

  @Id
  @Column(name = "airline_company_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getAirlineCompanyId() {
    return airlineCompanyId;
  }

  public void setAirlineCompanyId(Long airlineCompanyId) {
    this.airlineCompanyId = airlineCompanyId;
  }

  @Basic
  @Column("company_name")
  public String getCompanyName() { return companyName; }

  public void setCompanyName(String companyName) { this.companyName = companyName; }

  @Basic
  @Column("passenger_capacity")
  public int getPassengerCapacity() { return passengerCapacity; }

  public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

  @Basic
  @Column("nation")
  public String getNation() { return nation; }

  public void setNation(String nation) { this.nation = nation; }

  @OneToMany(mappedBy = "companyContact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("companyContactId")
  public List<CompanyContactEntity> getCompanyContactList() { return companyContactList; }

  public void setCompanyContactList(List<CompanyContactEntity> companyContactList) { this.companyContactList = companyContactList; }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @Column(columnDefinition = "flight")
  public List<FlightEntity> getFlightEntityList() {
    return flightEntityList;
  }

  public void setFlightEntityList(List<FlightEntity> flightEntityList) {
    this.flightEntityList = flightEntityList;
  }
}
