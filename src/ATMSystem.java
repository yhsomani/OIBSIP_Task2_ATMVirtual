import java.util.Scanner;
//Oasis Task 2
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user id: ");
        int userId = scanner.nextInt();

        System.out.print("Enter user pin: ");
        int userPin = scanner.nextInt();

        User user = new User(userId, userPin);

        if (user.isAuthenticated()) {
            System.out.println("Welcome to the ATM system!");
            ATMMenu.showMenu(user);
        } else {
            System.out.println("Invalid user id or pin.");
        }
    }
}
