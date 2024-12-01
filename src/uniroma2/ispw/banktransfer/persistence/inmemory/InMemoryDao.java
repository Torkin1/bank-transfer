package uniroma2.ispw.banktransfer.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import uniroma2.ispw.banktransfer.persistence.Dao;

/**
 * In-memory implementation of the Dao interface.
 */
public abstract class InMemoryDao<K, V> implements Dao<K, V> {

    private Map<K, V> memory = new HashMap<>();

    protected void store(K key, V value) {
        memory.put(key, value);
    }

    @Override
    public void delete(K id) {
        memory.remove(id);
        
    }

    @Override
    public boolean exists(K id) {
        return memory.containsKey(id);
    }

    @Override
    public V load(K id) {
        return memory.get(id);
    }

    @Override
    public void store(V entity) {
        K key = getKey(entity);
        store(key, entity);
    }

    /**
     * Returns the key used to identify the entity from its
     * attributes.
     * @param value
     * @return
     */
    protected abstract K getKey(V value);
}
