package control;

import entity.Account;
import persistence.AccountDao;
import persistence.AccountDaoFactory;

public class MoneyTransferController {
    
    private AccountDao accountDao = AccountDaoFactory.getInstance().getAccountDao();
    
    public void transferMoney(TransferMoneyBean bean) {
        if (bean.getAmount() <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        Account sourceAccount = accountDao.loadAccount(bean.getSourceAccountId());
        Account destinationAccount = accountDao.loadAccount(bean.getDestinationAccountId());

        sourceAccount.debit(bean.getAmount());
        destinationAccount.credit(bean.getAmount());

        accountDao.storeAccount(sourceAccount);
        accountDao.storeAccount(destinationAccount);
    }
}