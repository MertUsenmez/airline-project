package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.AirlineCompany;
import com.airline.airlineapp.dao.CompanyContact;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.model.AirlineCompanyEntity;
import com.airline.airlineapp.model.CompanyContactEntity;
import com.airline.airlineapp.repository.AirlineCompanyRepository;
import com.airline.airlineapp.service.IAirlineCompanyService;
import com.airline.airlineapp.type.EnumerationDefinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AirlineCompanyServiceImpl extends AbstactBasicService implements IAirlineCompanyService {

  @Autowired
  private AirlineCompanyRepository airlineCompanyRepository;

  @Override
  public CrudResponse createAirlineCompany(CrudRequest crudRequest) {
    if(!this.validateRequest(crudRequest)) {
      CrudResponse crudResponse = new CrudResponse();
      crudResponse.setReturnStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
      crudResponse.setReturnCode(EnumerationDefinations.HttpStatus.BAD_REQUEST.getStatus());
      crudResponse.setMessage("did not save!");
      return crudResponse;
    }
    boolean saved = this.saveAirlineCompany(crudRequest);

    return this.buildResponse(saved);
  }

  @Override
  public List<AirlineCompany> searchAirlineCompany(String name, String nation) {

    List<AirlineCompanyEntity> companyEntities = Objects.nonNull(name) ? airlineCompanyRepository.findByCompanyName(name) : null;
    List<AirlineCompany> airlineCompanies = new ArrayList<>();

    if (!CollectionUtils.isEmpty(companyEntities)) {
      for (AirlineCompanyEntity company : companyEntities) {
        AirlineCompany airlineCompany = new AirlineCompany();
        airlineCompany.setCompanyName(company.getCompanyName());
        airlineCompany.setNation(company.getNation());
        airlineCompany.setPassengerCapacity(company.getPassengerCapacity());

        List<CompanyContact> companyContacts = new ArrayList<>();
        for (CompanyContactEntity companyContactEntity : company.getCompanyContactList()) {
          CompanyContact companyContact = new CompanyContact();
          companyContact.setCountry(companyContactEntity.getCountry());
          companyContact.setAddressDecription(companyContactEntity.getAddressDecription());
          companyContact.setFax(companyContactEntity.getFax());
          companyContact.setCity(companyContactEntity.getCity());
          companyContact.setMobilePhone(companyContactEntity.getMobilePhone());
          companyContacts.add(companyContact);
        }

        airlineCompany.setCompanyContacts(companyContacts);
        airlineCompanies.add(airlineCompany);
      }
    }

    return airlineCompanies;
  }

  private boolean saveAirlineCompany(CrudRequest crudRequest) {
    AirlineCompanyEntity airlineCompanyEntity = new AirlineCompanyEntity();
    airlineCompanyEntity.setCompanyName(crudRequest.getName());
    airlineCompanyEntity.setNation(crudRequest.getNation());
    airlineCompanyEntity.setPassengerCapacity(crudRequest.getPassengerCapacity());

    List<CompanyContactEntity> companyContactEntityList = new ArrayList<>();
    for (CompanyContact companyContact: crudRequest.getCompanyContacts()) {
      CompanyContactEntity companyContactEntity = new CompanyContactEntity();
      companyContactEntity.setCity(companyContact.getCity());
      companyContactEntity.setCountry(companyContact.getCountry());
      companyContactEntity.setFax(companyContact.getFax());
      companyContactEntity.setMobilePhone(companyContact.getMobilePhone());
      companyContactEntity.setAddressDecription(companyContact.getAddressDecription());
      companyContactEntityList.add(companyContactEntity);
    }
    //companyContactEntityList = companyContactRepository.saveAll(companyContactEntityList);
    airlineCompanyEntity.setCompanyContactList(companyContactEntityList);
    airlineCompanyRepository.save(airlineCompanyEntity);

    return true;
  }

}
