package com.airline.airlineapp.dao;

public class CrudResponse {

  private String returnStatus;
  private long returnCode;
  private String description;
  private String message;

  public String getReturnStatus() {
    return returnStatus;
  }

  public void setReturnStatus(String returnStatus) {
    this.returnStatus = returnStatus;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(long returnCode) {
    this.returnCode = returnCode;
  }
}
