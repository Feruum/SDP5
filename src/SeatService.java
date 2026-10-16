public class SeatService {
    private final boolean[] seats;

    public SeatService(int seatCount) {
        if (seatCount < 1) {
            throw new IllegalArgumentException("Seat count must be positive.");
        }
        seats = new boolean[seatCount];
    }

    public void reserveSeat(int seatNumber) {
        int index = checkSeat(seatNumber);
        if (seats[index]) {
            throw new IllegalStateException("Seat " + seatNumber + " is already reserved.");
        }
        seats[index] = true;
    }

    public void releaseSeat(int seatNumber) {
        int index = checkSeat(seatNumber);
        if (!seats[index]) {
            throw new IllegalStateException("Seat " + seatNumber + " is not reserved.");
        }
        seats[index] = false;
    }

    private int checkSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            throw new IllegalArgumentException("Seat must be between 1 and " + seats.length + ".");
        }
        return seatNumber - 1;
    }
}
