package bg.softuni.pathfinderDemo.service;

import bg.softuni.pathfinderDemo.model.entity.User;
import bg.softuni.pathfinderDemo.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);

    boolean isNameExits(String username);

    User findCurrentUserId();
}
