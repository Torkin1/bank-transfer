package uniroma2.ispw.banktransfer.boundary;

import uniroma2.ispw.banktransfer.control.AccountsController;
import uniroma2.ispw.banktransfer.control.RegisterAccountBean;

public class RegisterAccountBoundary {

    AccountsController accountsController = AccountsController.getInstance();
    
    public void registerAccount(String username, String accountId, double initialBalance) {
        try {
            accountsController.registerAccount(new RegisterAccountBean(username, accountId, initialBalance));
            System.out.println("Account registered: " + accountId + " with initial balance " + initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("Account registration failed: " + e.getMessage());
        }
    }
    
}
