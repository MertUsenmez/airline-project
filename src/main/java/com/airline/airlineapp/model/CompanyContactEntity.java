package com.airline.airlineapp.model;

import javax.persistence.*;

@Entity
@Table(name="company_contact")
public class CompanyContactEntity {

  private Long companyContactId;
  private String city;
  private String country;
  private String mobilePhone;
  private String fax;
  private String addressDecription;
  private AirlineCompanyEntity airlineCompany;
  private AirportEntity airport;

  @Id
  @Column(name = "company_contact_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getCompanyContactId() {
    return companyContactId;
  }

  public void setCompanyContactId(Long companyContactId) { this.companyContactId = companyContactId; }

  @Basic
  @Column("city")
  public String getCity() { return city; }

  public void setCity(String city) { this.city = city; }

  @Basic
  @Column("country")
  public String getCountry() { return country; }

  public void setCountry(String country) { this.country = country; }

  @Basic
  @Column("mobilePhone")
  public String getMobilePhone() { return mobilePhone; }

  public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }

  @Basic
  @Column("fax")
  public String getFax() { return fax; }

  public void setFax(String fax) { this.fax = fax; }

  @Basic
  @Column("addressDecription")
  public String getAddressDecription() { return addressDecription; }

  public void setAddressDecription(String addressDecription) { this.addressDecription = addressDecription; }

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airline_company_id", referencedColumnName = "airline_company_id", insertable = false, updatable = false)
  public AirlineCompanyEntity getAirlineCompany() { return airlineCompany; }

  public void setAirlineCompany(AirlineCompanyEntity airlineCompany) { this.airlineCompany = airlineCompany; }

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "airport_id", referencedColumnName = "airport_id", insertable = false, updatable = false)
  public AirportEntity getAirport() {
    return airport;
  }

  public void setAirport(AirportEntity airport) {
    this.airport = airport;
  }
}
