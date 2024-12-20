package uniroma2.ispw.banktransfer.persistence.inmemory;

import java.util.ArrayList;
import java.util.List;

import uniroma2.ispw.banktransfer.entity.Account;
import uniroma2.ispw.banktransfer.entity.User;
import uniroma2.ispw.banktransfer.persistence.Dao;
import uniroma2.ispw.banktransfer.persistence.DaoFactory;
import uniroma2.ispw.banktransfer.persistence.UserDao;

public class InMemoryUserDao extends InMemoryDao<String, User> implements UserDao {

    private static InMemoryUserDao instance;

    private InMemoryUserDao() {
        // private constructor to prevent instantiation
    }

    public static InMemoryUserDao getInstance() {
        if (instance == null) {
            instance = new InMemoryUserDao();
        }
        return instance;
    }

    private Dao<String, Account> accountDao = DaoFactory.getInstance().getAccountDao();

    @Override
    protected String getKey(User user) {
        return user.getUsername();
    }

    @Override
    public User load(String id) {
        
        List<Account> accounts = new ArrayList<>();
        User user = super.load(id);
        if (user != null) {
            // refresh accounts
            for (Account account : user.getAccounts()) {
                accounts.add(accountDao.load(account.getAccountId()));
            }
            user.setAccounts(accounts);    
        }
        return user;
    }

    @Override
    public void store(User entity) {
        for (Account account : entity.getAccounts()) {
            accountDao.store(account);
        }
        super.store(entity);
    }
    
    
}
