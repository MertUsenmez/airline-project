package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.CreditCard;
import com.airline.airlineapp.dao.FligthSearchRequest;
import com.airline.airlineapp.dao.Ticket;
import com.airline.airlineapp.dao.TicketSearchRequest;
import com.airline.airlineapp.model.CreditCardEntity;
import com.airline.airlineapp.model.TicketEntity;
import com.airline.airlineapp.repository.CreditCardRepository;
import com.airline.airlineapp.repository.TicketRepository;
import com.airline.airlineapp.service.ITicketService;
import com.airline.airlineapp.type.EnumerationDefinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TicketServiceImpl extends AbstactBasicService implements ITicketService {

  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private CreditCardRepository creditCardRepository;


  @Override
  public Ticket buy(Ticket ticket) {
    if (Objects.nonNull(ticket)) {
      try {

        this.toPay(ticket);
        return ticket;

      } catch (Exception exception) {

      } finally {
        Ticket errorTicket = new Ticket();
        errorTicket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
        errorTicket.setStatusCode(EnumerationDefinations.HttpStatus.INTERNAL_ERROR.getStatus());
        errorTicket.setMessage("an error accoured");
        return errorTicket;
      }

    }
    ticket.setStatusCode(EnumerationDefinations.HttpStatus.BAD_REQUEST.getStatus());
    ticket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
    ticket.setMessage("Request is null.");

    return ticket;
  }

  @Override
  public Ticket cancel(Ticket ticket) {
    if (ticket != null && ticket.getTicketCode() != null) {
      TicketEntity ticketEntity = ticketRepository.findByTicketCodeAndIsActive(ticket.getTicketCode());
      if (Objects.nonNull(ticketEntity) && Objects.nonNull(ticketEntity.getFlightEntity()) && Objects.nonNull(ticketEntity.getFlightEntity().getFlightQuota())) {
        ticketEntity.getFlightEntity().setFlightQuota(ticketEntity.getFlightEntity().getFlightQuota() + 1);
        ticketEntity.setIsActive(0);
        ticketRepository.save(ticketEntity);
        ticket.setIsActive(0);
        return ticket;
      } else {
        ticket.setStatusCode(EnumerationDefinations.HttpStatus.NOT_FOUND.getStatus());
        ticket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
        ticket.setMessage("Ticket do not found.");
        return ticket;
      }
    }
    ticket.setStatusCode(EnumerationDefinations.HttpStatus.BAD_REQUEST.getStatus());
    ticket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
    ticket.setMessage("Request is null.");
    return ticket;
  }

  @Override
  public Ticket search(TicketSearchRequest ticketSearchRequest) {

    Ticket ticket = new Ticket();

    if (Objects.isNull(ticketSearchRequest) && Objects.isNull(ticketSearchRequest.getTicketCode())) {
      ticket.setStatusCode(EnumerationDefinations.HttpStatus.BAD_REQUEST.getStatus());
      ticket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
      ticket.setMessage("Request is null.");
      return ticket;
    }

    TicketEntity ticketEntity = ticketRepository.findByTicketCodeAndIsActive(ticketSearchRequest.getTicketCode());
    if (Objects.nonNull(ticketEntity)) {
      ticket.setTicketId(ticketEntity.getTicketId());
      ticket.setTicketCode(ticketEntity.getTicketCode());
      ticket.setPrice(ticketEntity.getPrice());
      ticket.setFlightEntity(ticketEntity.getFlightEntity());
      CreditCard creditCard = new CreditCard();
      creditCard.setMaskedCardNumber(ticketEntity.getCreditCardEntity().getMaskedCardNumber());
    } else {
      ticket.setStatusCode(EnumerationDefinations.HttpStatus.NOT_FOUND.getStatus());
      ticket.setStatus(EnumerationDefinations.ReturnStatus.ERROR.getShortCode());
      ticket.setMessage("Ticket do not found.");
    }

    return ticket;
  }

  private boolean toPay(Ticket ticket) {
    CreditCard creditCard = ticket.getCreditCard();
    CreditCardEntity creditCardEntity = new CreditCardEntity();
    creditCardEntity.setCardName(creditCard.getCardName());
    creditCardEntity.setBalance(creditCard.getBalance());
    creditCardEntity.setIsActive(1);
    creditCardEntity.setMaskedCardNumber(maskCardNumber(creditCard.getMaskedCardNumber(), "####-##xx-xxxx-####"));
    creditCardEntity.setExpireDate(creditCard.getExpireDate());
    creditCardEntity.setBalance(creditCard.getBalance() - ticket.getPrice());

    TicketEntity ticketEntity = new TicketEntity();
    ticketEntity.setTicketId(ticket.getTicketId());
    ticketEntity.setTicketCode(ticket.getTicketCode());
    ticketEntity.setPrice(ticket.getPrice());
    ticketEntity.setIsActive(1);
    ticketEntity.setCreditCardEntity(creditCardEntity);
    ticketEntity.setFlightEntity(ticket.getFlightEntity());

    if (Objects.nonNull(ticketEntity.getFlightEntity())) {
      ticketEntity.getFlightEntity().setFlightQuota(ticketEntity.getFlightEntity().getFlightQuota() - 1);
    }

    creditCardEntity.getTicketEntityList().add(ticketEntity);

    creditCardRepository.save(creditCardEntity);

    return true;
  }

  private String maskCardNumber(String cardNumber, String mask) {

    // format the number
    int index = 0;
    StringBuilder maskedNumber = new StringBuilder();
    for (int i = 0; i < mask.length(); i++) {
      char c = mask.charAt(i);
      if (c == '#') {
        maskedNumber.append(cardNumber.charAt(index));
        index++;
      } else if (c == 'x') {
        maskedNumber.append(c);
        index++;
      } else {
        maskedNumber.append(c);
      }
    }

    // return the masked number
    return maskedNumber.toString();
  }

}
