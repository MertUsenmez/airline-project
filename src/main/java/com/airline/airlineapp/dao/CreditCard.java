package com.airline.airlineapp.dao;

import com.airline.airlineapp.model.TicketEntity;

import java.util.List;

public class CreditCard {

  private Long creditCardId;
  private String cardName;
  private String expireDate;
  private Integer isActive;
  private String maskedCardNumber;
  private Double balance;
  private List<Ticket> ticketList;

  public Long getCreditCardId() {
    return creditCardId;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public void setCreditCardId(Long creditCardId) {
    this.creditCardId = creditCardId;
  }

  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public Integer getIsActive() {
    return isActive;
  }

  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  public String getMaskedCardNumber() {
    return maskedCardNumber;
  }

  public void setMaskedCardNumber(String maskedCardNumber) {
    this.maskedCardNumber = maskedCardNumber;
  }

  public List<Ticket> getParent() {
    return ticketList;
  }

  public void setParent(List<Ticket> ticketList) {
    this.ticketList = ticketList;
  }
}
