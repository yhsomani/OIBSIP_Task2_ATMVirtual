import java.util.Scanner;

public class ATMMenu {
    public static void showMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Please select an option:");
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewTransactionHistory(user);
                    break;
                case 2:
                    withdraw(user);
                    break;
                case 3:
                    deposit(user);
                    break;
                case 4:
                    transfer(user);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewTransactionHistory(User user) {
        for (Transaction transaction : user.getTransactionHistory()) {
            System.out.println(transaction.getType() + " of amount " + transaction.getAmount() + " on " + transaction.getDate());
        }
    }

    private static void withdraw(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (user.isAuthenticated()) {
            if (amount > 10000) {
                System.out.println("Withdrawal limit exceeded.");
                return;
            }

            user.addTransactionToHistory(new Transaction(Transaction.TransactionType.WITHDRAW, amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid user id or pin.");
        }
    }

    private static void deposit(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (user.isAuthenticated()) {
            user.addTransactionToHistory(new Transaction(Transaction.TransactionType.DEPOSIT, amount));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid user id or pin.");
        }
    }

    private static void transfer(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        System.out.print("Enter recipient's user id: ");
        int recipientUserId = scanner.nextInt();

        if (recipientUserId <= 0) {
            System.out.println("Invalid user id.");
            return;
        }

        if (user.isAuthenticated()) {
            if (amount > 10000) {
                System.out.println("Transfer limit exceeded.");
                return;
            }

            user.addTransactionToHistory(new Transaction(Transaction.TransactionType.TRANSFER, amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid user id or pin.");
        }
    }
}
