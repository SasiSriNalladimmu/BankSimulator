import java.util.Scanner;

public class BankSimulator {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int role;

        do {
            System.out.println("\n--- Welcome to Bank Simulator ---");
            System.out.println("1. Manager");
            System.out.println("2. Bank Officer");
            System.out.println("3. Customer");
            System.out.println("4. Exit");
            System.out.print("Choose role: ");
            role = sc.nextInt();
            sc.nextLine();

            switch (role) {
                case 1 -> {
                    if (Manager.login(sc)) {
                        Manager.showMenu(sc);
                    } else {
                        System.out.println("Invalid manager credentials.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter officer name: ");
                    String name = sc.nextLine();
                    if (Utils.loadOfficers().contains(name)) {
                        BankOfficer.showMenu(sc, name);
                    } else {
                        System.out.println("Officer not found.");
                    }
                }
                case 3 -> {
                    System.out.println("\n--- Customer Login ---");
                    System.out.print("Enter Account Number or Name: ");
                    String input = sc.nextLine();

                    Account acc = Utils.findAccount(input);  // Try by account number first

                    // If not found by account number, try by name
                    if (acc == null) {
                        acc = Utils.findAccountByName(input);
                    }

                    if (acc != null) {
                        System.out.println("Login successful. Welcome, " + acc.getName() + "!");
                        boolean custMenu = true;
                        while (custMenu) {
                            System.out.println("\n--- Customer Menu ---");
                            System.out.println("1. View Account Details");
                            System.out.println("2. Logout");
                            System.out.print("Choose an option: ");
                            int copt = sc.nextInt();
                            sc.nextLine();

                            switch (copt) {
                                case 1 -> {
                                    System.out.println("\n=== Account Details ===");
                                    System.out.println("Account Number : " + acc.getAccountNumber());
                                    System.out.println("Name           : " + acc.getName());
                                    System.out.println("DOB            : " + acc.getDob());
                                    System.out.println("Address        : " + acc.getAddress());
                                    System.out.println("Phone          : " + acc.getPhone());
                                    System.out.println("Aadhaar        : " + acc.getAadhaar());
                                    System.out.println("PAN            : " + acc.getPan());
                                    System.out.println("Balance        : Rs. " + acc.getBalance());
                                }
                                case 2 -> {
                                    custMenu = false;
                                    System.out.println("Logged out.");
                                }
                                default ->
                                    System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        System.out.println("! Account not found.");
                    }
                }

                case 4 ->
                    System.out.println("Thank you for using Bank Simulator.");
                default ->
                    System.out.println("Invalid role.");
            }
        } while (role != 3);

        sc.close();
    }
}
