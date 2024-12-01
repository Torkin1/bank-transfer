package boundary;

import control.AccountsController;
import control.RegisterAccountBean;

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
