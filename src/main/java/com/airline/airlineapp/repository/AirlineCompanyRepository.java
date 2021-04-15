package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.AirlineCompanyEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineCompanyRepository extends BaseJpaRepository<AirlineCompanyEntity, Long> {

  List<AirlineCompanyEntity> findByCompanyName(@Param("companyName") String companyName);
}
