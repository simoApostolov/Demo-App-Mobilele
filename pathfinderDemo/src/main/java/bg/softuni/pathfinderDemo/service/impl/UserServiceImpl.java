package bg.softuni.pathfinderDemo.service.impl;

import bg.softuni.pathfinderDemo.model.entity.User;
import bg.softuni.pathfinderDemo.model.entity.enums.Level;
import bg.softuni.pathfinderDemo.model.service.UserServiceModel;
import bg.softuni.pathfinderDemo.repository.UserRepository;
import bg.softuni.pathfinderDemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevel(Level.BEGINNER);

        userRepository.save(user);

    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
            currentUser.setUsername(username);
            currentUser.setId(id);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean isNameExits(String username) {


        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public User findCurrentUserId() {

        return userRepository.findById(currentUser.getId())
                .orElse(null);
    }
}
