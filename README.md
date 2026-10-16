# Cinema Ticket Booking

Talgat Madi | SE-2537

A simple Java console project using the Facade pattern. It models one showing with
5 seats, tickets costing 2000 KZT, and one wallet starting at 5000 KZT. Data is kept
in memory and resets when the program restarts.

## Run

Install JDK 17 or newer. Run these commands from the project folder:

```sh
javac -d out src/*.java
java -cp out Main
```

The program runs a fixed demonstration. It shows successful bookings, an occupied
seat, insufficient funds, cancellation, rebooking after a failed payment, an
invalid seat, an unknown ticket, and repeated cancellation.

## Pattern roles

| Class | Role |
| --- | --- |
| `Main` | Client; calls only the facade. |
| `CinemaFacade` | Offers `bookTicket` and `cancelTicket`. |
| `SeatService` | Reserves and releases validated seats. |
| `PaymentService` | Charges and refunds the wallet. |
| `TicketService` | Creates, finds, and removes stored tickets. |
| `Ticket` | Stores the ticket ID, seat number, and original price. |

Booking reserves a seat, charges the wallet, and creates a ticket. A payment
failure releases the seat. An expected ticket creation failure refunds the
payment and releases the seat. Cancellation first finds the ticket, then refunds
its original price, releases the seat, and removes the ticket. An unknown or
already cancelled ticket fails before any state changes.

The services do not depend on the facade. The facade keeps their instances
private, so the client does not need to coordinate them.

Topic choice: Option C (free topic). Instructor confirmation of this topic is
still required before submission.

## Repository

The included local Git repository contains real incremental commits created
during implementation. It has no remote and has not been published to GitHub.
The author email `talgat.madi@local.invalid` is a local placeholder. Set your own
email before making future commits.

To publish it yourself:

1. Create an empty repository in your GitHub account.
2. Copy its real repository URL.
3. Replace both placeholders below with your own values and run the commands.

```sh
git config user.email "YOUR_ACTUAL_EMAIL"
git remote add origin "PASTE_YOUR_REAL_REPOSITORY_URL_HERE"
git push -u origin main
```

Use the actual published repository URL for submission. The placeholder above is
not a submission link.
