import java.util.Scanner;

public class BankOfficer {

    public static void showMenu(Scanner sc, String officerName) {
        int choice;

        do {
            System.out.println("\n--- Bank Officer Menu ---");
            System.out.println("Officer: " + officerName);
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createAccount(sc);
                case 2 -> viewAccount(sc);
                case 3 -> deposit(sc);
                case 4 -> withdraw(sc);
                case 5 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void createAccount(Scanner sc) {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Aadhaar: ");
        String aadhaar = sc.nextLine();
        System.out.print("PAN: ");
        String pan = sc.nextLine();
        System.out.print("Enter account type: ");
        String accType = sc.nextLine();

        String accountNumber = Utils.generateAccountNumber();
        Account acc = new Account(accountNumber, name, gender, dob, address, phone, aadhaar, pan, accType, 0.0);
        Utils.saveAccount(acc);
        System.out.println("Account created: " + accountNumber);
        Utils.logTransaction("Account created for " + name + " (" + accountNumber + ")");
    }

    public static void viewAccount(Scanner sc) {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        Account acc = Utils.findAccount(accountNumber);
        if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void deposit(Scanner sc) {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        Account acc = Utils.findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        acc.setBalance(acc.getBalance() + amount);
        Utils.updateAccount(acc);
        System.out.println("Deposited. New balance: Rs. " + acc.getBalance());
        Utils.logTransaction("Deposited Rs. " + amount + " to " + accountNumber);
    }

    public static void withdraw(Scanner sc) {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        Account acc = Utils.findAccount(accountNumber);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0 || amount > acc.getBalance()) {
            System.out.println("Invalid or insufficient balance.");
            return;
        }

        acc.setBalance(acc.getBalance() - amount);
        Utils.updateAccount(acc);
        System.out.println("Withdrawn. New balance: Rs. " + acc.getBalance());
        Utils.logTransaction("Withdrew Rs. " + amount + " from " + accountNumber);
    }
}
