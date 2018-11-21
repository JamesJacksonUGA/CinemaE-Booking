package cinema.booking.repositories;

import org.springframework.data.repository.CrudRepository;

import cinema.booking.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
