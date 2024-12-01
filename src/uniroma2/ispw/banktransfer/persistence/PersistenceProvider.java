package uniroma2.ispw.banktransfer.persistence;

import uniroma2.ispw.banktransfer.persistence.inmemory.InMemoryDaoFactory;

public enum PersistenceProvider {

    IN_MEMORY("in memory", InMemoryDaoFactory.class);

    private final String name;
    private final Class<? extends DaoFactory> daoFactoryClass;

    private PersistenceProvider(String name, Class<? extends DaoFactory> daoFactoryClass) {
        this.name = name;
        this.daoFactoryClass = daoFactoryClass;
    }

    public String getName() {
        return name;
    }
    
    public Class<? extends DaoFactory> getDaoFactoryClass() {
        return daoFactoryClass;
    }


    @Override
    public String toString() {
        return getName();
    }
    
    
}