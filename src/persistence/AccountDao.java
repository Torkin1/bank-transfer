package persistence;

import entity.Account;

public interface AccountDao extends Dao<String, Account> {
    @Override
    default Account create(String key){
        return new Account(key, 0);
    }
}
