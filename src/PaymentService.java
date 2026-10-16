public class PaymentService {
    private int balance;

    public PaymentService(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public void pay(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Payment must be positive.");
        }
        if (amount > balance) {
            throw new IllegalStateException("Not enough money. Balance: " + balance + " KZT.");
        }
        balance -= amount;
    }

    public void refund(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Refund must be positive.");
        }
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
