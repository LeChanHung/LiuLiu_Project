
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://MEAP\\SQLEXPRESS:1433;databaseName= Quiz";
            String username = "sa";
            String password = "hung1802";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
//    public static void main(String[] args) {
//        try{
//            System.out.println(new DBContext().connection);
//        }catch(Exception e){
//            
//        }
//    }
}

