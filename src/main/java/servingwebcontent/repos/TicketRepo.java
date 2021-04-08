package servingwebcontent.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import servingwebcontent.db.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Long> {
}
