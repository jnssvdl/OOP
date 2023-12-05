package bank;

import java.util.HashMap;

public class SharedAccount extends Account {
    private static int userCounter = 0;
    private HashMap<String, String> users = new HashMap<>();

    public SharedAccount(String pin, String id, double balance) {
        super(pin, id, balance);
        this.users.put(pin, this.getId() + userCounter);
    }
    
    public boolean addUser(String pin) {
        if (this.isValidPin(pin)) { // no duplicate pin
            return false;
        }
        userCounter++;
        this.users.put(pin, this.getId() + userCounter);
        return true;
    }

    public String getId(String pin) {
        return this.users.get(pin);
    }

    public boolean isValidPin(String pin) {
        for (String userPin : this.users.keySet()) {
            if (pin.equals(userPin)) {
                return true;
            }
        }
        return false;
    }

    public boolean changePin(String oldPin, String newPin) {
        if (!this.isValidPin(oldPin)) {
            return false; 
        }
        String id = this.users.remove(oldPin);
        this.users.put(newPin, id);
        return true;
    }
}
