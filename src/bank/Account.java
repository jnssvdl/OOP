package bank;

public class Account {
    private String pin;
    private String id;
    private double balance;
    
    public Account(String pin, String id, double balance) {
        this.pin = pin;
        this.id = id;
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
