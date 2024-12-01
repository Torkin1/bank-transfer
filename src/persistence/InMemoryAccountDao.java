package persistence;

import java.util.HashMap;
import java.util.Map;

import entity.Account;

public class InMemoryAccountDao implements AccountDao {
    
    private static InMemoryAccountDao instance = new InMemoryAccountDao();

    public static InMemoryAccountDao getInstance() {
        return instance;
    }

    private InMemoryAccountDao() {
    }
    
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void storeAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    @Override
    public Account loadAccount(String accountId) {
        return accounts.get(accountId);
    }
    
}
