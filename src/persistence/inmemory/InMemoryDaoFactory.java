package persistence.inmemory;

import persistence.AccountDao;
import persistence.DaoFactory;
import persistence.UserDao;

/**
 * Concrete dao factory for in-memory only daos.
 */
public class InMemoryDaoFactory extends DaoFactory{

    @Override
    public AccountDao getAccountDao() {
        return InMemoryAccountDao.getInstance();
    }

    @Override
    public UserDao getUserDao() {
        return InMemoryUserDao.getInstance();
    }
    
}
