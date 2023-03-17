package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    public void userSave(User user){
        boolean userValid= true;
        for(int i = 0; i < user.getUsername().length(); i++ ){
            if (Character.isDigit(user.getUsername().charAt(i))){
                userValid = false;
            }
        }
        if (userValid){
            userRepository.save(user);
        }
        else
            System.out.println("wrong username");
    }
    public void userUpdate(User user){
        boolean userValid= true;
        for(int i = 0; i < user.getUsername().length(); i++ ){
            if (Character.isDigit(user.getUsername().charAt(i))){
                userValid = false;
            }
        }
        if (userValid){
            userRepository.update(user);
        }
        else
            System.out.println("wrong username");
    }
    public void userDelete(int id){
        userRepository.delete(id);
    }

    public User userLoad(int id){
        return userRepository.load(id);
    }
    public User[] userLoadAll(){
       return userRepository.loadAll();
    }
}
