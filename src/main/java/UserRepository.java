import java.sql.*;

public class UserRepository {
    public void save(User user){
        String query = "INSERT INTO user_account(username,pass_word)VALUES(?,?)";
        Connection connection = JDBCConnection.connetToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.userame);
            statement.setString(2,user.password);
            statement.execute();
        }catch (SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }

    }
    /*public void delete(int id){

    }

    public User load(int id){

    }*/
    public void Update (User user){
        String query = "UPDATE user_account SET username = ?, pass_word = ? WHERE user_id = ?";
        Connection connection = JDBCConnection.connetToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.userame);
            statement.setString(2,user.password);
            statement.setInt(3,user.uesrId);
            statement.execute();
        }catch (SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }
    }
}
