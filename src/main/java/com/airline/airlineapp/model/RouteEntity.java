package com.airline.airlineapp.model;

import javax.persistence.*;

public class RouteEntity {

  private Long routeId;
  private AirportEntity comingFrom;
  private AirportEntity goingOn;
  private String estimatedTime;

  @Id
  @Column("route_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
  }

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "coming_from", referencedColumnName = "airport_id", insertable = false, updatable = false)
  public AirportEntity getComingFrom() {
    return comingFrom;
  }

  public void setComingFrom(AirportEntity comingFrom) {
    this.comingFrom = comingFrom;
  }

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "going_on", referencedColumnName = "airport_id", insertable = false, updatable = false)
  public AirportEntity getGoingOn() {
    return goingOn;
  }

  public void setGoingOn(AirportEntity goingOn) {
    this.goingOn = goingOn;
  }

  @Basic
  @Column("estimated_time")
  public String getEstimatedTime() {
    return estimatedTime;
  }

  public void setEstimatedTime(String estimatedTime) {
    this.estimatedTime = estimatedTime;
  }
}
