package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.type.EnumerationDefinations;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

public class AbstactBasicService {

  protected boolean validateRequest(CrudRequest crudRequest) {
    boolean acceptableRequest = false;
    if (Objects.nonNull(crudRequest)) {
      acceptableRequest = Objects.nonNull(crudRequest.getName()) && !CollectionUtils.isEmpty(crudRequest.getCompanyContacts());
    }
    if (acceptableRequest != true) {
      return false;
    }
    return true;
  }

  protected CrudResponse buildResponse(boolean saved) {
    CrudResponse crudResponse = new CrudResponse();

    if (saved) {
      crudResponse.setReturnStatus(EnumerationDefinations.ReturnStatus.SUCCESS.getShortCode());
      crudResponse.setReturnCode(EnumerationDefinations.HttpStatus.SUCCESS.getStatus());
      crudResponse.setMessage("Saved");

    } else {
      crudResponse.setReturnStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
      crudResponse.setReturnCode(EnumerationDefinations.HttpStatus.NO_CONTENT.getStatus());
      crudResponse.setMessage("did not save!");
    }

    return crudResponse;
  }

  protected CrudResponse buildFailResponse() {
    CrudResponse crudResponse = new CrudResponse();
    crudResponse.setReturnStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
    crudResponse.setReturnCode(EnumerationDefinations.HttpStatus.INTERNAL_ERROR.getStatus());
    crudResponse.setMessage("did not save!");
    return crudResponse;
  }

}
