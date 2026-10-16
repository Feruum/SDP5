public class Ticket {
    private final int id;
    private final int seatNumber;
    private final int price;

    public Ticket(int id, int seatNumber, int price) {
        if (id < 1 || seatNumber < 1 || price < 1) {
            throw new IllegalArgumentException("Ticket values must be positive.");
        }
        this.id = id;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }
}
