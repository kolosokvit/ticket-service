package ticketservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ticketservice.model.Ticket;
import ticketservice.model.TicketType;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    @Query(value = "SELECT * FROM tickets WHERE ticket_id = ?1", nativeQuery = true)
    List<Ticket> getTicketsByUserId(int id);

    @Modifying
    @Query(value = "UPDATE tickets SET ticket_type = ?1::ticket_type WHERE ticket_id = ?2", nativeQuery = true)
    int updateTicketType(TicketType ticketType, int id);

}
