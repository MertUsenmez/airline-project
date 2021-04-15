package com.airline.airlineapp.dao;

public class Route {

  private Long routeId;
  private Airport comingFrom;
  private Airport goingOn;
  private String estimatedTime;

  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }

  public Airport getComingFrom() {
    return comingFrom;
  }

  public void setComingFrom(Airport comingFrom) {
    this.comingFrom = comingFrom;
  }

  public Airport getGoingOn() {
    return goingOn;
  }

  public void setGoingOn(Airport goingOn) {
    this.goingOn = goingOn;
  }

  public String getEstimatedTime() {
    return estimatedTime;
  }

  public void setEstimatedTime(String estimatedTime) {
    this.estimatedTime = estimatedTime;
  }
}
