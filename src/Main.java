public class Main {
    public static void main(String[] args) {
        CinemaFacade cinema = new CinemaFacade();
        System.out.println("Cinema Ticket Booking");
        System.out.println("5 seats. Ticket price: 2000 KZT. Initial wallet: 5000 KZT.");

        System.out.println("\nSuccessful booking: seat 1");
        int firstTicket = cinema.bookTicket(1);
        System.out.println("Booked: ticket #" + firstTicket + ", seat 1.");

        System.out.println("\nOccupied seat: seat 1");
        tryBooking(cinema, 1);

        System.out.println("\nSecond successful booking: seat 2");
        int secondTicket = cinema.bookTicket(2);
        System.out.println("Booked: ticket #" + secondTicket + ", seat 2.");

        System.out.println("\nInsufficient funds: seat 3");
        tryBooking(cinema, 3);

        System.out.println("\nCancel the first ticket");
        cinema.cancelTicket(firstTicket);
        System.out.println("Cancelled: ticket #" + firstTicket + ".");

        System.out.println("\nRetry seat 3 after the failed payment");
        int retryTicket = cinema.bookTicket(3);
        System.out.println("Booked: ticket #" + retryTicket + ", seat 3.");

        System.out.println("\nInvalid seat: seat 0");
        tryBooking(cinema, 0);

        System.out.println("\nUnknown ticket: ticket #999");
        tryCancellation(cinema, 999);

        System.out.println("\nCancel the first ticket again");
        tryCancellation(cinema, firstTicket);
    }

    private static void tryBooking(CinemaFacade cinema, int seatNumber) {
        try {
            int ticketId = cinema.bookTicket(seatNumber);
            System.out.println("Booked: ticket #" + ticketId + ", seat " + seatNumber + ".");
        } catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println("Booking failed: " + error.getMessage());
        }
    }

    private static void tryCancellation(CinemaFacade cinema, int ticketId) {
        try {
            cinema.cancelTicket(ticketId);
            System.out.println("Cancelled: ticket #" + ticketId + ".");
        } catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println("Cancellation failed: " + error.getMessage());
        }
    }
}
