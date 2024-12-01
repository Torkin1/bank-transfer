package boundary;

import java.util.Map.Entry;

import control.AccountsController;
import control.BalancesBean;
import control.MoneyTransferController;
import control.TransferMoneyBean;

public class MoneyTransferBoundary {
    private MoneyTransferController moneyTransferController = MoneyTransferController.getInstance();
    private AccountsController accountsController = AccountsController.getInstance();
    public void transferMoney(String sourceAccountUsername, String sourceAccountId, String destinationAccountUsername, String destinationAccountId, double amount) {

        try {
            // do transfer
            TransferMoneyBean transferMoneyBean =
             new TransferMoneyBean(sourceAccountId, destinationAccountId, amount, sourceAccountUsername, destinationAccountUsername);
            moneyTransferController.transferMoney(transferMoneyBean);
            System.out.println("Transfer successful: " + amount + " from " + sourceAccountId + " to " + destinationAccountId);
            
            // show updated balances
            BalancesBean sourceBalancesBean = new BalancesBean(sourceAccountUsername);
            BalancesBean destinationBalancesBean = new BalancesBean(destinationAccountUsername);
            accountsController.getBalances(sourceBalancesBean);
            accountsController.getBalances(destinationBalancesBean);
            System.out.println("Updated balances:");
            printUserBalances(sourceBalancesBean);
            printUserBalances(destinationBalancesBean);
        } catch (IllegalArgumentException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }

    private void printUserBalances(BalancesBean balancesBean) {
        System.out.println(balancesBean.getUsername() + " balances:");
        for (Entry<String, Double> account: balancesBean.getBalances().entrySet()) {
            System.out.println(account.getKey() + ": " + account.getValue());
        }
    }

}