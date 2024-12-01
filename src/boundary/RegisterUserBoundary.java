package boundary;

import control.UserBean;
import control.RegisterUserController;

public class RegisterUserBoundary {

    private RegisterUserController registerUserController = RegisterUserController.getInstance();
    
    public void registerUser(String username){

        registerUserController.registerUser(new UserBean(username));

    }
    
}
