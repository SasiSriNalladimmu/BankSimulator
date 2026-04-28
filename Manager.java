import java.io.*;
import java.util.*;

public class Manager {
    private static final String USERNAME = "GowriSai";
    private static final String PASSWORD = "GowriSai@123";

    public static boolean login(Scanner sc) {
        System.out.print("Enter Manager Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Manager Password: ");
        String pass = sc.nextLine();
        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }

    public static void showMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. View All Accounts");
            System.out.println("2. View Bank Officers");
            System.out.println("3. Add Bank Officer");
            System.out.println("4. Remove Bank Officer");
            System.out.println("5. Edit Customer Data");
            System.out.println("6. View Logs");
            System.out.println("7. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewAllAccounts();
                case 2 -> viewOfficers();
                case 3 -> addOfficer(sc);
                case 4 -> removeOfficer(sc);
                case 5 -> editCustomer(sc);
                case 6 -> viewLogs();
                case 7 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }

    public static void viewAllAccounts() {
        List<Account> accounts = Utils.loadAccounts();
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    public static void viewOfficers() {
        Utils.loadOfficers().forEach(System.out::println);
    }

    public static void addOfficer(Scanner sc) {
        System.out.print("Enter new officer name: ");
        String name = sc.nextLine();
        List<String> officers = Utils.loadOfficers();
        officers.add(name);
        Utils.saveOfficers(officers);
        System.out.println("Officer added.");
    }

    public static void removeOfficer(Scanner sc) {
        List<String> officers = Utils.loadOfficers();
        for (int i = 0; i < officers.size(); i++) {
            System.out.println((i + 1) + ". " + officers.get(i));
        }
        System.out.print("Enter number to remove: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 1 && index <= officers.size()) {
            officers.remove(index - 1);
            Utils.saveOfficers(officers);
            System.out.println("Officer removed.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    public static void editCustomer(Scanner sc) {
        System.out.print("Enter Account Number to edit: ");
        String accountNumber = sc.nextLine();
        Account acc = Utils.findAccount(accountNumber);
        if (acc != null) {
            System.out.println("Editing Account for: " + acc.getName());
            System.out.print("Enter new address: ");
            acc.setAddress(sc.nextLine());
            System.out.print("Enter new phone: ");
            acc.setPhone(sc.nextLine());
            Utils.updateAccount(acc);
            System.out.println("Account updated.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void viewLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/transactions.txt"))) {
            String line;
            System.out.println("--- Transaction Logs ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading logs.");
        }
    }
}
