package com.airline.airlineapp.dao;

public class AbstarctGenericDao {

  protected Long statusCode;
  protected String status;
  protected String message;

  public Long getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Long statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
