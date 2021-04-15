package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.*;
import com.airline.airlineapp.model.AirportEntity;
import com.airline.airlineapp.model.CompanyContactEntity;
import com.airline.airlineapp.repository.AirportRepository;
import com.airline.airlineapp.service.IAirportService;
import com.airline.airlineapp.type.EnumerationDefinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AirportServiceImpl extends AbstactBasicService implements IAirportService {

  @Autowired
  private AirportRepository airportRepository;

  @Override
  public CrudResponse createAirport(Airport airport) {
    if(Objects.nonNull(airport)) {
      CrudResponse crudResponse = new CrudResponse();
      crudResponse.setReturnStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
      crudResponse.setReturnCode(EnumerationDefinations.HttpStatus.BAD_REQUEST.getStatus());
      crudResponse.setMessage("did not save!");
      return crudResponse;
    }
    boolean saved = this.saveAirport(airport);

    return this.buildResponse(saved);
  }

  @Override
  public List<Airport> searchAirport(String name, String nation) {
    List<AirportEntity> airportEntities = Objects.nonNull(name) ? airportRepository.findByAirportName(name) : null;
    List<Airport> airports = new ArrayList<>();

    if (!CollectionUtils.isEmpty(airportEntities)) {
      for (AirportEntity airportEntity : airportEntities) {
        Airport airport = new Airport();
        airport.setAirportName(airportEntity.getAirportName());

        CompanyContact companyContact = new CompanyContact();
        companyContact.setCountry(airportEntity.getContact().getCountry());
        companyContact.setAddressDecription(airportEntity.getContact().getAddressDecription());
        companyContact.setFax(airportEntity.getContact().getFax());
        companyContact.setCity(airportEntity.getContact().getCity());
        companyContact.setMobilePhone(airportEntity.getContact().getMobilePhone());
        airport.setContact(companyContact);
      }
    }

    return airports;
  }

  private boolean saveAirport(Airport airport) {
    AirportEntity airportEntity = new AirportEntity();
    airportEntity.setAirportName(airport.getAirportName());

    CompanyContactEntity companyContactEntity = new CompanyContactEntity();
    if (Objects.nonNull(airport.getContact())) {
      companyContactEntity.setCity(airport.getContact().getCity());
      companyContactEntity.setCountry(airport.getContact().getCountry());
      companyContactEntity.setFax(airport.getContact().getFax());
      companyContactEntity.setMobilePhone(airport.getContact().getMobilePhone());
      companyContactEntity.setAddressDecription(airport.getContact().getAddressDecription());
    }

    airportEntity.setContact(companyContactEntity);
    airportRepository.save(airportEntity);

    return true;
  }

}
