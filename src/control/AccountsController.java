package control;

import entity.Account;
import entity.User;
import persistence.AccountDao;
import persistence.DaoFactory;
import persistence.UserDao;

public class AccountsController {

    private static AccountsController instance;

    private AccountsController() {
        // private constructor to prevent instantiation
    }

    public static AccountsController getInstance() {
        if (instance == null) {
            instance = new AccountsController();
        }
        return instance;
    }

    AccountDao accountDao = DaoFactory.getInstance().getAccountDao();
    UserDao userDao = DaoFactory.getInstance().getUserDao();

    public void getBalances(BalancesBean bean) {
        
        // get balances of all accounts of the user
        User user = userDao.load(bean.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("User " + bean.getUsername() + " is not registered.");
        }
        for (Account account : user.getAccounts()) {
            bean.getBalances().put(account.getAccountId(), account.getBalance());
        }

    }
    
    public void registerAccount(RegisterAccountBean bean) {
        // cannot register an account with already a debt
        if (bean.getInitialBalance() < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }
        // account to register must belong to a user
        User user = userDao.load(bean.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("User " + bean.getUsername() + " is not registered.");
        }
        // account to register must not be already registered
        if (hasAccount(user, bean.getAccountId())) {
            throw new IllegalArgumentException("Account " + bean.getAccountId() + "for user " + bean.getUsername() +" is already registered.");
        }

        // creates account with desired initial balance and links it
        // to the user
        Account account = accountDao.create(bean.getAccountId());
        account.setBalance(bean.getInitialBalance());
        user.getAccounts().add(account);
        accountDao.store(account);
        userDao.store(user);
    }
    
    private boolean hasAccount(User user, String accountId) {
        for (Account account : user.getAccounts()) {
            if (account.getAccountId().equals(accountId)) {
                return true;
            }
        }
        return false;
    }
    
}
