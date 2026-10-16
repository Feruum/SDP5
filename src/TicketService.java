import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private final Map<Integer, Ticket> tickets = new HashMap<>();
    private int nextId = 1;

    public Ticket createTicket(int seatNumber, int price) {
        Ticket ticket = new Ticket(nextId, seatNumber, price);
        tickets.put(nextId, ticket);
        nextId++;
        return ticket;
    }

    public Ticket findTicket(int ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket #" + ticketId + " was not found.");
        }
        return ticket;
    }

    public void removeTicket(int ticketId) {
        findTicket(ticketId);
        tickets.remove(ticketId);
    }
}
