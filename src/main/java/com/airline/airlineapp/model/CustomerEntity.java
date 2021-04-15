package com.airline.airlineapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerEntity {

  private Long customerId;
  private String firstName;
  private String lastName;
  private int age;
  private List<TicketEntity> ticketEntityList;
  private List<CreditCardEntity> creditCardEntityList;

  @Id
  @Column("customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  @Basic
  @Column("first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column("last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column("age")
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @OneToMany(mappedBy = "ticketEntityList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  public List<TicketEntity> getTicketEntityList() {
    return ticketEntityList;
  }

  public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
    this.ticketEntityList = ticketEntityList;
  }

  @OneToMany(mappedBy = "creditCardEntityList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  public List<CreditCardEntity> getCreditCardEntityList() {
    return creditCardEntityList;
  }

  public void setCreditCardEntityList(List<CreditCardEntity> creditCardEntityList) {
    this.creditCardEntityList = creditCardEntityList;
  }
}
