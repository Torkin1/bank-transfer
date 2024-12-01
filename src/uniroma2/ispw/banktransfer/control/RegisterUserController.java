package uniroma2.ispw.banktransfer.control;

import uniroma2.ispw.banktransfer.entity.User;
import uniroma2.ispw.banktransfer.persistence.DaoFactory;
import uniroma2.ispw.banktransfer.persistence.UserDao;

public class RegisterUserController {

    private static RegisterUserController instance;

    private RegisterUserController() {
    }

    public static RegisterUserController getInstance() {
        if (instance == null) {
            instance = new RegisterUserController();
        }
        return instance;
    }

    private UserDao userDao = DaoFactory.getInstance().getUserDao();

    public void registerUser(UserBean bean) {
        if (userDao.load(bean.getUsername()) != null) {
            throw new IllegalArgumentException("User already exists.");
        }
        User user = userDao.create(bean.getUsername());
        userDao.store(user);
    }
    
}
