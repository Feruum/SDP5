import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cinema Ticket Booking");
        System.out.println("5 seats. Ticket price: 2000 KZT.");

        try (Scanner scanner = new Scanner(System.in)) {
            Integer initialBalance;
            while (true) {
                initialBalance = readNumber(scanner, "Starting wallet balance (KZT): ");
                if (initialBalance == null) {
                    return;
                }
                if (initialBalance >= 0) {
                    break;
                }
                System.out.println("Balance cannot be negative.");
            }

            CinemaFacade cinema = new CinemaFacade(initialBalance);

            while (true) {
                System.out.println("\n1. Book ticket");
                System.out.println("2. Cancel ticket");
                System.out.println("0. Exit");
                Integer choice = readNumber(scanner, "Choose: ");
                if (choice == null) {
                    return;
                }
                if (choice == 0) {
                    System.out.println("Goodbye.");
                    return;
                }

                try {
                    if (choice == 1) {
                        Integer seatNumber = readNumber(scanner, "Seat number (1-5): ");
                        if (seatNumber == null) {
                            return;
                        }
                        int ticketId = cinema.bookTicket(seatNumber);
                        System.out.println("Booked: ticket #" + ticketId
                                + ", seat " + seatNumber + ".");
                    } else if (choice == 2) {
                        Integer ticketId = readNumber(scanner, "Ticket ID: ");
                        if (ticketId == null) {
                            return;
                        }
                        cinema.cancelTicket(ticketId);
                        System.out.println("Cancelled: ticket #" + ticketId + ".");
                    } else {
                        System.out.println("Choose 1, 2, or 0.");
                    }
                } catch (IllegalArgumentException | IllegalStateException error) {
                    System.out.println("Error: " + error.getMessage());
                }
            }
        }
    }

    private static Integer readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                System.out.println("Input ended.");
                return null;
            }
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }
}
