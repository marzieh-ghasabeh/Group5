import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection connetToDB(){
        String dburl = "jdbc:postgresql://localhost:5432/group5";
        String user = "postgres";
        String pass = "marzieh@1371";
        Connection connect1=null;
        try {
             connect1 = DriverManager.getConnection(dburl,user,pass);
            System.out.println("something");
        }catch (SQLException e){
            System.out.println("wrong entry");
            e.printStackTrace();
        }
        return connect1;
    }
}
