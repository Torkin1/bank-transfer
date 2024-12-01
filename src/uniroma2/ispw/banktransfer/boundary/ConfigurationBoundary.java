package uniroma2.ispw.banktransfer.boundary;

import uniroma2.ispw.banktransfer.persistence.DaoFactory;
import uniroma2.ispw.banktransfer.persistence.PersistenceProvider;

public class ConfigurationBoundary {
    
    public void setPersistenceProvider(String provider) {
        // finds the persistence provider by name.
        // This way we don't need to change the boundary if we add a new provider.
        for (PersistenceProvider p : PersistenceProvider.values()) {
            if (p.getName().equals(provider)) {
                DaoFactory.setPersitenceProvider(p);
                return;
            }
        }
    }
    
}
