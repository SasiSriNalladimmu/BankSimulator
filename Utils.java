import java.io.*;
import java.util.*;

public class Utils {

    public static String generateAccountNumber() {
        Random rand = new Random();
        int unique = 10000000 + rand.nextInt(90000000);
        return "GS" + unique;
    }

    public static void saveAccount(Account acc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/accounts.txt", true))) {
            writer.write(acc.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving account.");
        }
    }

    public static List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 10) {
                    Account acc = new Account(
                        parts[0], parts[1], parts[2], parts[3],
                        parts[4], parts[5], parts[6], parts[7],
                        parts[8], Double.parseDouble(parts[9])
                    );
                    accounts.add(acc);
                }
            }
        } catch (IOException e) {
            System.out.println("No accounts found.");
        }
        return accounts;
    }

    public static Account findAccount(String accountNumber) {
        for (Account acc : loadAccounts()) {
            if (acc.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public static void updateAccount(Account updatedAcc) {
        List<Account> accounts = loadAccounts();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/accounts.txt"))) {
            for (Account acc : accounts) {
                if (acc.getAccountNumber().equals(updatedAcc.getAccountNumber())) {
                    writer.write(updatedAcc.toString());
                } else {
                    writer.write(acc.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating account.");
        }
    }

    public static List<String> loadOfficers() {
        List<String> officers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/officers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                officers.add(line);
            }
        } catch (IOException e) {
            System.out.println("No officers found.");
        }
        return officers;
    }

    public static void saveOfficers(List<String> officers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/officers.txt"))) {
            for (String officer : officers) {
                writer.write(officer);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving officers.");
        }
    }

    public static Account findAccountByName(String name) {
        for (Account acc : loadAccounts()) {
            if (acc.getName().equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }

    public static void logTransaction(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/transactions.txt", true))) {
            writer.write(new Date() + " - " + data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Transaction logging failed.");
        }
    }
}
