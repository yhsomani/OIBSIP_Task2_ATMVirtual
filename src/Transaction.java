import java.util.Date;

public class Transaction {
    public enum TransactionType {
        WITHDRAW,
        DEPOSIT,
        TRANSFER
    }

    private TransactionType type;
    private int amount;
    private Date date;

    public Transaction(TransactionType type, int amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public TransactionType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
