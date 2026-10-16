public class CinemaFacade {
    private static final int TICKET_PRICE = 2000;
    private final SeatService seatService;
    private final PaymentService paymentService;
    private final TicketService ticketService;

    public CinemaFacade() {
        seatService = new SeatService(5);
        paymentService = new PaymentService(5000);
        ticketService = new TicketService();
    }

    public int bookTicket(int seatNumber) {
        seatService.reserveSeat(seatNumber);

        try {
            paymentService.pay(TICKET_PRICE);
        } catch (IllegalArgumentException | IllegalStateException error) {
            seatService.releaseSeat(seatNumber);
            throw error;
        }

        Ticket ticket;
        try {
            ticket = ticketService.createTicket(seatNumber, TICKET_PRICE);
        } catch (IllegalArgumentException | IllegalStateException error) {
            paymentService.refund(TICKET_PRICE);
            seatService.releaseSeat(seatNumber);
            throw error;
        }

        return ticket.getId();
    }

    public void cancelTicket(int ticketId) {
        Ticket ticket = ticketService.findTicket(ticketId);
        paymentService.refund(ticket.getPrice());
        seatService.releaseSeat(ticket.getSeatNumber());
        ticketService.removeTicket(ticketId);

    }
}
