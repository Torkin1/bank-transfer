package uniroma2.ispw.banktransfer.persistence.inmemory;

import uniroma2.ispw.banktransfer.persistence.AccountDao;
import uniroma2.ispw.banktransfer.persistence.DaoFactory;
import uniroma2.ispw.banktransfer.persistence.UserDao;

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
