package com.airline.airlineapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="flight")
public class FlightEntity {

  private Long flightId;
  private String flightCode;
  private int isActive;
  private Integer flightQuota;
  private RouteEntity routeEntity;
  private AirlineCompanyEntity airlineCompanyEntity;
  private List<TicketEntity> ticketEntityList;

  @Id
  @Column(name = "flight_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getFlightId() {
    return flightId;
  }

  public void setFlightId(Long flightId) {
    this.flightId = flightId;
  }

  @Basic
  @Column("flight_code")
  public String getFlightCode() {
    return flightCode;
  }

  public void setFlightCode(String flightCode) {
    this.flightCode = flightCode;
  }

  @Basic
  @Column("is_active")
  public int getIsActive() {
    return isActive;
  }

  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }

  @Basic
  @Column("flight_quota")
  public Integer getFlightQuota() {
    return flightQuota;
  }

  public void setFlightQuota(Integer flightQuota) {
    this.flightQuota = flightQuota;
  }

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "route_id", referencedColumnName = "route_id")
  public RouteEntity getRouteEntity() {
    return routeEntity;
  }

  public void setRouteEntity(RouteEntity routeEntity) {
    this.routeEntity = routeEntity;
  }

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "airline_company_id", referencedColumnName = "airline_company_id")
  public AirlineCompanyEntity getAirlineCompanyEntity() {
    return airlineCompanyEntity;
  }

  public void setAirlineCompanyEntity(AirlineCompanyEntity airlineCompanyEntity) {
    this.airlineCompanyEntity = airlineCompanyEntity;
  }

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
  public List<TicketEntity> getTicketEntityList() {
    return ticketEntityList;
  }

  public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
    this.ticketEntityList = ticketEntityList;
  }
}
