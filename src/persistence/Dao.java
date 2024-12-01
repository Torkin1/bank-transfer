package persistence;

public interface Dao<ID, E> {
    E load(ID id);
    void store(E entity);
    void delete(ID id);
    boolean exists(ID id);

    // factory method to create a new entity
    E create(ID id);

}
