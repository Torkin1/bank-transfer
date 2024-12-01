import boundary.ConfigurationBoundary;
import boundary.MoneyTransferBoundary;

public class Driver {
    public static void main(String[] args) {
        
        // Set persistence provider
        ConfigurationBoundary configurationBoundary = new ConfigurationBoundary();
        configurationBoundary.setPersistenceProvider("in memory");

        MoneyTransferBoundary moneyTransferBoundary = new MoneyTransferBoundary();

        // Create accounts
        moneyTransferBoundary.registerAccount("A001", 1000);
        moneyTransferBoundary.registerAccount("A002", 500);

        // Perform money transfer
        moneyTransferBoundary.transferMoney("A001", "A002", 200);

        // Try an invalid transfer
        moneyTransferBoundary.transferMoney("A001", "A002", 900);
    }
}