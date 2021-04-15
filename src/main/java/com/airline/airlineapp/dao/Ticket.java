package com.airline.airlineapp.dao;

import com.airline.airlineapp.model.FlightEntity;

public class Ticket extends AbstarctGenericDao {

  private Long ticketId;
  private String ticketCode;
  private Double price;
  private int isActive;
  private FlightEntity flightEntity;
  private CreditCard creditCard;


  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getTicketCode() {
    return ticketCode;
  }

  public void setTicketCode(String ticketCode) {
    this.ticketCode = ticketCode;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getIsActive() {
    return isActive;
  }

  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }

  public FlightEntity getFlightEntity() {
    return flightEntity;
  }

  public void setFlightEntity(FlightEntity flightEntity) {
    this.flightEntity = flightEntity;
  }

  public CreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
  }
}
