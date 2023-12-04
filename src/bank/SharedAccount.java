package bank;

import java.util.HashMap;

public class SharedAccount extends Account {
    private HashMap<String, String> users = new HashMap<>();

    public SharedAccount(String pin, String id, double balance) {
        super(id, pin, balance);
        //TODO Auto-generated constructor stub
        this.users.put(this.getPin(), this.getId());
    }
    
    public void addUser(String id, String pin) {
        users.put(id, pin);
    }

}
