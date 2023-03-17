package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public void userSave(User user){
        userRepository.save(user);
    }
}
