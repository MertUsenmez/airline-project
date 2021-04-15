package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.TicketEntity;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends BaseJpaRepository<TicketEntity, Long> {
  TicketEntity findByTicketCodeAndIsActive(@Param("ticketCode") String ticketCode);
}
