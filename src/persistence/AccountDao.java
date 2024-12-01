package persistence;

import entity.Account;

public interface AccountDao {
    void storeAccount(Account account);
    Account loadAccount(String accountId);
}
