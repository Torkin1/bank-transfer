package uniroma2.ispw.banktransfer.persistence.inmemory;

import uniroma2.ispw.banktransfer.entity.Account;
import uniroma2.ispw.banktransfer.persistence.AccountDao;

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
