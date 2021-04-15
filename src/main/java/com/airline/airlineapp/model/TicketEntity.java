package com.airline.airlineapp.model;

import javax.persistence.*;

@Entity
@Table(name="ticket")
public class TicketEntity {

  private Long ticketId;
  private String ticketCode;
  private Double price;
  private Integer isActive;
  private FlightEntity flightEntity;
  private CreditCardEntity creditCardEntity;

  @Id
  @Column("ticket_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  @Basic
  @Column("ticket_code")
  public String getTicketCode() {
    return ticketCode;
  }

  public void setTicketCode(String ticketCode) {
    this.ticketCode = ticketCode;
  }

  @Basic
  @Column("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Basic
  @Column("is_active")
  public Integer getIsActive() {
    return isActive;
  }

  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
  public FlightEntity getFlightEntity() {
    return flightEntity;
  }

  public void setFlightEntity(FlightEntity flightEntity) {
    this.flightEntity = flightEntity;
  }

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "credit_card_id", referencedColumnName = "credit_card_id")
  public CreditCardEntity getCreditCardEntity() {
    return creditCardEntity;
  }

  public void setCreditCardEntity(CreditCardEntity creditCardEntity) {
    this.creditCardEntity = creditCardEntity;
  }
}
