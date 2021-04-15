package com.airline.airlineapp.dao;

import com.airline.airlineapp.model.AirlineCompanyEntity;
import com.airline.airlineapp.model.RouteEntity;

public class Flight {

  private Long flightId;
  private String flightCode;
  private Integer flightQuota;
  private int isActive;
  private RouteEntity routeEntity;
  private AirlineCompanyEntity airlineCompanyEntity;

  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  public String getFlightCode() {
    return flightCode;
  }

  public void setFlightCode(String flightCode) {
    this.flightCode = flightCode;
  }

  public Integer getFlightQuota() {
    return flightQuota;
  }

  public void setFlightQuota(Integer flightQuota) {
    this.flightQuota = flightQuota;
  }

  public RouteEntity getRouteEntity() {
    return routeEntity;
  }

  public int getIsActive() {
    return isActive;
  }

  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }

  public void setRouteEntity(RouteEntity routeEntity) {
    this.routeEntity = routeEntity;
  }

  public AirlineCompanyEntity getAirlineCompanyEntity() {
    return airlineCompanyEntity;
  }

  public void setAirlineCompanyEntity(AirlineCompanyEntity airlineCompanyEntity) {
    this.airlineCompanyEntity = airlineCompanyEntity;
  }
}
