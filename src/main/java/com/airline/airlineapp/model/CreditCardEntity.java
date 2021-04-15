package com.airline.airlineapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="credit_card")
public class CreditCardEntity {

  private Long creditCardId;
  private String cardName;
  private String expireDate;
  private Integer isActive;
  private String maskedCardNumber;
  private Double balance;
  private List<TicketEntity> ticketEntityList = new ArrayList<>();

  @Id
  @Column("credit_card_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getCreditCardId() {
    return creditCardId;
  }

  public void setCreditCardId(Long creditCardId) {
    this.creditCardId = creditCardId;
  }

  @Basic
  @Column("card_name")
  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  @Basic
  @Column("expire_date")
  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  @Basic
  @Column("is_active")
  public Integer getIsActive() {
    return isActive;
  }

  public void setIsActive(Integer isActive) {
    this.isActive = isActive;
  }

  @Basic
  @Column("masked_card_number")
  public String getMaskedCardNumber() {
    return maskedCardNumber;
  }

  public void setMaskedCardNumber(String maskedCardNumber) {
    this.maskedCardNumber = maskedCardNumber;
  }

  @Basic
  @Column("balance")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  public List<TicketEntity> getTicketEntityList() {
    return ticketEntityList;
  }

  public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
    this.ticketEntityList = ticketEntityList;
  }
}
