package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.CompanyContactEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyContactRepository extends BaseJpaRepository<CompanyContactEntity, Long> {
}
