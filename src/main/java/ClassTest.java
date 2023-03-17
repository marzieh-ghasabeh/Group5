import entity.User;
import repository.UserRepository;
import service.UserService;

import java.util.Arrays;

public class ClassTest {
    public static void main(String[] args) {
       UserRepository userRepository = new UserRepository();
       User user = new User("Marzieh","hello");
        User user1 = new User("Nooshin","hello");
        User user2 = new User("Fateme","hello");
        User user3 = new User("Sara","hello");
        User user4 = new User("Mahdie","hello");

        UserService userService = new UserService();
        System.out.println(Arrays.toString(userService.userLoadAll()));
   /*     User[] users = {user,user1,user2,user3,user4};
        userRepository.saveAll(users);*/
/*        User newuser = new User("ali","hello");
        System.out.println(userRepository.save(newuser));*/

    }

}
