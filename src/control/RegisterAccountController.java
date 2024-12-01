package control;

import entity.Account;
import persistence.AccountDao;
import persistence.AccountDaoFactory;

public class RegisterAccountController {

    AccountDao accountDao = AccountDaoFactory.getInstance().getAccountDao();
    
    public void registerAccount(RegisterAccountBean bean) {
        if (bean.getInitialBalance() < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }

        Account account = accountDao.loadAccount(bean.getAccountId());
        if (account != null) {
            throw new IllegalArgumentException("Account " + bean.getAccountId() + " is already registered.");
        }
        account = new Account(bean.getAccountId(), bean.getInitialBalance());
        accountDao.storeAccount(account);
    }
    
}
