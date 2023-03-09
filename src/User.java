import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private int userPin;
    private List<Transaction> transactionHistory;

    public User(int userId, int userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.transactionHistory = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public int getUserPin() {
        return userPin;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransactionToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public boolean isAuthenticated() {
        // In a real system, we would compare the user id and pin against a database of users
        return userId == 1234 && userPin == 5678;
    }
}
