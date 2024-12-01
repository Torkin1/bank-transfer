package boundary;

import control.MoneyTransferController;
import control.RegisterAccountBean;
import control.RegisterAccountController;
import control.TransferMoneyBean;

public class MoneyTransferBoundary {
    private MoneyTransferController moneyTransferController = new MoneyTransferController();
    private RegisterAccountController registerAccountController = new RegisterAccountController();

    public void transferMoney(String sourceAccountId, String destinationAccountId, double amount) {

        try {
            TransferMoneyBean transferMoneyBean =
             new TransferMoneyBean(sourceAccountId, destinationAccountId, amount);
            moneyTransferController.transferMoney(transferMoneyBean);
            System.out.println("Transfer successful: " + amount + " from " + sourceAccountId + " to " + destinationAccountId);
            System.out.println("Updated balances:");
            System.out.println(sourceAccountId + ": " + transferMoneyBean.getUpdatedSourceBalance());
            System.out.println(destinationAccountId + ": " + transferMoneyBean.getUpdatedDestinationBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }

    public void registerAccount(String accountId, double initialBalance) {
        try {
            registerAccountController.registerAccount(new RegisterAccountBean(accountId, initialBalance));
            System.out.println("Account registered: " + accountId + " with initial balance " + initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println("Account registration failed: " + e.getMessage());
        }
    }
}