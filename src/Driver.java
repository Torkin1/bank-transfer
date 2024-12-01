import boundary.ConfigurationBoundary;
import boundary.MoneyTransferBoundary;
import boundary.RegisterAccountBoundary;
import boundary.RegisterUserBoundary;

/**
 * Mocks an interaction between a generic actor and the system.
 */
public class Driver {
    public static void main(String[] args) {
        
        // Set persistence provider
        ConfigurationBoundary configurationBoundary = new ConfigurationBoundary();
        configurationBoundary.setPersistenceProvider("in memory");

        MoneyTransferBoundary moneyTransferBoundary = new MoneyTransferBoundary();
        RegisterAccountBoundary registerAccountBoundary = new RegisterAccountBoundary();
        RegisterUserBoundary registerUserBoundary = new RegisterUserBoundary();

        // Create accounts and users
        // TODO: what if account ids were not unique, but depended
        // on the user id? 
        registerUserBoundary.registerUser("Il Magnifico Rettore");
        registerUserBoundary.registerUser("Il tutor di ISPW");
        registerAccountBoundary.registerAccount("Il Magnifico Rettore","A001", 1000);
        registerAccountBoundary.registerAccount("Il tutor di ISPW","A002", 500);

        // Perform money transfer
        moneyTransferBoundary.transferMoney("Il Magnifico Rettore", "A001", "Il tutor di ISPW", "A002", 900);

        // Try an invalid transfer
        moneyTransferBoundary.transferMoney("Il Magnifico Rettore", "A001", "Il tutor di ISPW", "A002", 900);
    }
}