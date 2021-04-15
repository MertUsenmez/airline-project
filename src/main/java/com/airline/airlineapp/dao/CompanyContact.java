package com.airline.airlineapp.dao;

public class CompanyContact {

  private Long companyContactId;
  private String city;
  private String country;
  private String mobilePhone;
  private String fax;
  private String addressDecription;

  public Long getCompanyContactId() {
    return companyContactId;
  }

  public void setCompanyContactId(Long companyContactId) {
    this.companyContactId = companyContactId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getAddressDecription() {
    return addressDecription;
  }

  public void setAddressDecription(String addressDecription) {
    this.addressDecription = addressDecription;
  }
}
