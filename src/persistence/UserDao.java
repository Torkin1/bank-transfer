package persistence;

import entity.User;

public interface UserDao extends Dao<String, User> {

    @Override
    default User create(String key){
        return new User(key);
    }
    
}
