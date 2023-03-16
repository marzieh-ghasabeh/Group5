import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassTest {
    public static void main(String[] args) {
       UserRepository userRepository = new UserRepository();
       User user = new User("marzieh","hello");
       user.setUesrId(1);
       userRepository.Update(user);
    }
}
