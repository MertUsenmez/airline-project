package com.airline.airlineapp.model;

import javax.persistence.*;

@Entity
@Table(name="airport")
public class AirportEntity {

  private Long airportId;
  private String airportName;
  private CompanyContactEntity contact;

  @Id
  @Column(name = "airport_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getAirportId() {
    return airportId;
  }

  public void setAirportId(Long airportId) {
    this.airportId = airportId;
  }

  @Basic
  @Column("airport_name")
  public String getAirportName() {
    return airportName;
  }

  public void setAirportName(String airportName) {
    this.airportName = airportName;
  }

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contact_id", referencedColumnName = "company_contact_id", insertable = false, updatable = false)
  public CompanyContactEntity getContact() {
    return contact;
  }

  public void setContact(CompanyContactEntity contact) {
    this.contact = contact;
  }
}
