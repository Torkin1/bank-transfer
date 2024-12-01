package uniroma2.ispw.banktransfer.control;

import uniroma2.ispw.banktransfer.entity.Account;
import uniroma2.ispw.banktransfer.entity.User;
import uniroma2.ispw.banktransfer.persistence.AccountDao;
import uniroma2.ispw.banktransfer.persistence.DaoFactory;
import uniroma2.ispw.banktransfer.persistence.UserDao;

public class MoneyTransferController {
    
    private static MoneyTransferController instance;

    private MoneyTransferController() {}

    public static synchronized MoneyTransferController getInstance() {
        if (instance == null) {
            instance = new MoneyTransferController();
        }
        return instance;
    }
    
    private AccountDao accountDao = DaoFactory.getInstance().getAccountDao();
    private UserDao userDao = DaoFactory.getInstance().getUserDao();
    
    public void transferMoney(TransferMoneyBean bean) {
        if (bean.getAmount() <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        User sourceAccountUser = userDao.load(bean.getSourceAccountUser());
        User destinationAccountUser = userDao.load(bean.getDestinationAccountUser());

        Account sourceAccount = sourceAccountUser.getAccount(bean.getSourceAccountId());
        Account destinationAccount = destinationAccountUser.getAccount(bean.getDestinationAccountId());

        sourceAccount.debit(bean.getAmount());
        destinationAccount.credit(bean.getAmount());

        accountDao.store(sourceAccount);
        accountDao.store(destinationAccount);
    }
}