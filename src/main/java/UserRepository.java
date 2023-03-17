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
    public void delete(int id){

    }

    public User load(int id) {
        String query = "SELECT * FROM user_account WHERE user_id=?";
        Connection connection = JDBCConnection.connetToDB();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()){
                return null;
            }
            int userId = resultSet.getInt("user_id");
            String name = resultSet.getString("username");
            String pass = resultSet.getString("pass_word");
            user = new User(name, pass);
            user.setUesrId(userId);
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
        return user;
    }

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
