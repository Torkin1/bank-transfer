package uniroma2.ispw.banktransfer.persistence;

import uniroma2.ispw.banktransfer.entity.User;

public interface UserDao extends Dao<String, User> {

    @Override
    default User create(String key){
        return new User(key);
    }
    
}
