package persistence.inmemory;

import entity.Account;
import persistence.AccountDao;

public class InMemoryAccountDao extends InMemoryDao<String, Account> implements AccountDao{

    private static InMemoryAccountDao instance;
    
    private InMemoryAccountDao() {
    }
    
    public static InMemoryAccountDao getInstance() {
        if (instance == null) {
            instance = new InMemoryAccountDao();
        }
        return instance;
    }
    
    @Override
    protected String getKey(Account account) {
        return account.getAccountId();
    }   
    
}
