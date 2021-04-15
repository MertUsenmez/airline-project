package com.airline.airlineapp.type;

public class EnumerationDefinations {

  protected EnumerationDefinations() {
  }

  public enum ReturnStatus {
   SUCCESS("Success"),
   ERROR("Error"),
   WARNING("Warning");

   private String shortCode;

    ReturnStatus(String shortCode) { this.shortCode = shortCode; }

   public String getShortCode() { return shortCode; }
  }

  public enum HttpStatus {
    BAD_REQUEST(400l),
    NO_CONTENT(204l),
    SUCCESS(200l),
    NOT_FOUND(404l),
    INTERNAL_ERROR(500l);

    private long status;

    HttpStatus(long status) { this.status = status;}

    public long getStatus() { return status; }
  }

}
