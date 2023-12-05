package bank;

import java.util.Scanner;

public class Simulation {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        simulation(accountCreation());
    }

    private static SharedAccount accountCreation() {
        System.out.println("* Account creation *");
        System.out.print("Enter pin: ");
        String pin = in.nextLine();
        System.out.print("Enter id: ");
        String id = in.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = in.nextDouble();
        in.nextLine();
        return new SharedAccount(pin, id, balance);
    }

    private static void simulation(SharedAccount account) {
        while (true) {
            System.out.println("* Logging in *");
            System.out.print("Enter pin: ");
            String pin = in.nextLine();
            if (account.isValidPin(pin)) {
                loggedIn(pin, account);
            } else {
                System.out.println("Invalid pin. ");
                continue;
            }
            System.out.print("Do you want to remove card? [Y]es [N]o: ");
            String remove = in.nextLine();
            if (remove.equalsIgnoreCase("Y")) {
                break;
            } else {
                continue;
            }
        }
    }
    
    private static void loggedIn(String pin, SharedAccount account) {
        while (true) {
            printMenu();
            System.out.print("Choice: ");
            String choice = in.nextLine();
            if (choice.equals("1")) {
                balance(account);
            } else if (choice.equals("2")) {
                withdraw(account);
            } else if (choice.equals("3")) {
                deposit(account);
            } else if (choice.equals("4")) {
                System.out.println("Your account ID is: " + account.getId(pin));
            } else if (choice.equals("5")) {
                changePin(account);
            } else if (choice.equals("6")) {
                addUser(account);
            } else {
                continue;
            }
            System.out.print("Do you want another transaction? [Y]es [No]: ");
            String another = in.nextLine();
            if (another.equalsIgnoreCase("Y")) {
                continue;
            } else {
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Logged in.");
        System.out.println("[1] Balance");
        System.out.println("[2] Withdraw");
        System.out.println("[3] Deposit");
        System.out.println("[4] User information");
        System.out.println("[5] Change pin");
        System.out.println("[6] Add new user");
    }

    private static void balance(SharedAccount account) {
        System.out.println("* Balance *");
        System.out.println("Current balance: " + account.getBalance());
    }

    private static void withdraw(SharedAccount account) {
        System.out.println("* Withdraw *");
        System.out.print("Amount: ");
        double amount = in.nextDouble();
        in.nextLine();
        if (account.withdraw(amount)) {
            System.out.println("Current balance: " + account.getBalance());
            return;
        }
        System.out.println("Not enough balance.");
    }

    private static void deposit(SharedAccount account) {
        System.out.println("* Deposit *");
        System.out.print("Amount: ");
        double amount = in.nextDouble();
        in.nextLine();
        account.deposit(amount);
        System.out.println("Current balance: " + account.getBalance());
    }

    private static void changePin(SharedAccount account) {
        System.out.print("Enter your old pin: ");
        String oldPin = in.nextLine();
        System.out.print("Enter your new pin: ");
        String newPin = in.nextLine();
        if (account.changePin(oldPin, newPin)) {
            System.out.println("Pin changed successfully.");
            return;
        }
        System.out.println("Pin doesn't exist.");
    }

    private static void addUser(SharedAccount account) {
        System.out.print("Enter new pin: ");
        if (account.addUser(in.nextLine())) {
            System.out.println("New pin successfully added.");
            return;
        }
        System.out.println("Pin already taken.");
    }

}
