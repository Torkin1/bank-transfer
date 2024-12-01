package boundary;

import persistence.AccountDaoFactory;
import persistence.InMemoryAccountDao;
import persistence.PersistenceProvider;

public class ConfigurationBoundary {

    AccountDaoFactory accountDaoFactory = AccountDaoFactory.getInstance();
    
    public void setPersistenceProvider(String provider) {
        if (provider == PersistenceProvider.IN_MEMORY.toString()) {
            accountDaoFactory.setAccountDaoImpl(InMemoryAccountDao.class);
        }
    }
    
}
