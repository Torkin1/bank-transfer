package uniroma2.ispw.banktransfer.boundary;

import uniroma2.ispw.banktransfer.control.RegisterUserController;
import uniroma2.ispw.banktransfer.control.UserBean;

public class RegisterUserBoundary {

    private RegisterUserController registerUserController = RegisterUserController.getInstance();
    
    public void registerUser(String username){

        registerUserController.registerUser(new UserBean(username));

    }
    
}
