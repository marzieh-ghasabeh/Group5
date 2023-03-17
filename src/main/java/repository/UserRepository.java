package repository;

import connection.JDBCConnection;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    public void save(User user){
        String query = "INSERT INTO user_account(username,pass_word)VALUES(?,?)";
        Connection connection = JDBCConnection.connetToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.execute();
        }catch (SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }

    }
    public void delete(int id){
        String query = "DELETE FROM user_account WHERE user_id = ?";
        Connection connection = JDBCConnection.connetToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }
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
            user.setId(userId);
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
        return user;
    }

    public void update(User user){
        String query = "UPDATE user_account SET username = ?, pass_word = ? WHERE user_id = ?";
        Connection connection = JDBCConnection.connetToDB();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("not connected");
            e.printStackTrace();
        }

    }
    public User[] loadAll(){
        String query = "SELECT * FROM user_account";
        Connection connection = JDBCConnection.connetToDB();
        User[] users = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery();

            int size = 0;
                resultSet.last();
                size = resultSet.getRow();
                resultSet.beforeFirst();

            users = new User[size];

            int i = 0;
            while (resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String pass = resultSet.getString("pass_word");
                User user = new User(name, pass);
                user.setId(userId);
                users[i] = user;
                i++;
            }

        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
        return users;
    }
}
