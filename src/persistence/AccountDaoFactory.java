package persistence;

public class AccountDaoFactory {
    private static AccountDaoFactory instance = new AccountDaoFactory();
    private Class<? extends AccountDao> accountDaoImplClazz; 

    public static AccountDaoFactory getInstance() {
        return instance;
    }

    private AccountDaoFactory() {
    }

    public void setAccountDaoImpl(Class<? extends AccountDao> accountDaoClazz){
        accountDaoImplClazz = accountDaoClazz;
    }

    public AccountDao getAccountDao() {
        if (accountDaoImplClazz == InMemoryAccountDao.class) {
            return InMemoryAccountDao.getInstance();
        }
        return null;
    }
    
}
