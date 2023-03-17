import entity.User;
import repository.UserRepository;

public class ClassTest {
    public static void main(String[] args) {
       UserRepository userRepository = new UserRepository();
       User user = new User("Marzieh","hello");
        User user1 = new User("Nooshin","hello");
        User user2 = new User("Fateme","hello");
        User user3 = new User("Sara","hello");
        User user4 = new User("Mahdie","hello");
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//        userRepository.save(user4);

//        user.setUesrId(1);
//       userRepository.Update(user1);
       userRepository.delete(5);
    }
}
