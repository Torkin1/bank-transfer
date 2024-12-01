package uniroma2.ispw.banktransfer.persistence;

import java.lang.reflect.InvocationTargetException;

/**
 * Abstract factory for creating DAO objects
 */
public abstract class DaoFactory{

    private static DaoFactory instance = null;
    private static PersistenceProvider persistenceProvider = null;

    public static void setPersitenceProvider(PersistenceProvider provider){
        persistenceProvider = provider;
    }

    public static DaoFactory getInstance() throws NoImplementationForPersistenceProviderException{
        if (instance == null) {
            try {
                instance = persistenceProvider.getDaoFactoryClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                throw new NoImplementationForPersistenceProviderException(persistenceProvider, e);
            }
        }
        return instance;
    }

    public abstract AccountDao getAccountDao();
    public abstract UserDao getUserDao();
}

