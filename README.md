# Cinema Ticket Booking

Talgat Madi | SE-2537

A simple Java console project using the Facade pattern. It models one showing with
5 seats and tickets costing 2000 KZT. The user enters the starting wallet balance
and chooses each action through a Scanner menu. Data is kept in memory and resets
when the program restarts.

## Run

Install JDK 17 or newer. Run these commands from the project folder:

```sh
javac -d out src/*.java
java -cp out Main
```

1. Enter a starting wallet balance, for example `5000`. Zero is allowed.
2. Choose `1` to book, then enter a seat number from `1` to `5`.
3. Choose `2` to cancel, then enter the ticket ID printed after booking.
4. Choose `0` to exit.

Invalid numbers are requested again. Negative starting balances are rejected.
Invalid menu choices and failed operations return to the menu. End-of-input exits
cleanly.

## Manual example

Start with `5000` KZT and enter these actions through the menu:

| Action | Expected result |
| --- | --- |
| Book seat 1 | Ticket #1; wallet becomes 3000 KZT. |
| Book seat 1 again | Occupied seat error; wallet stays 3000 KZT. |
| Book seat 2 | Ticket #2; wallet becomes 1000 KZT. |
| Book seat 3 | Insufficient funds; seat 3 is released. |
| Cancel ticket #1 | Refund 2000 KZT; wallet becomes 3000 KZT. |
| Book seat 3 again | Ticket #3; wallet becomes 1000 KZT. |

The successful retry shows that a failed payment does not leave the seat reserved.
Booking seat `0`, cancelling unknown ticket `999`, and cancelling ticket `1` again
all fail without changing the current bookings or wallet.

## Pattern roles

| Class | Role |
| --- | --- |
| `Main` | Reads user input and calls only the facade. |
| `CinemaFacade` | Accepts the initial balance; offers `bookTicket` and `cancelTicket`. |
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
