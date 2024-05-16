/*
 * This class establishes a connection to a MySQL database named "quanlybantivi".
 */
package DAO;

import MyCustom.MyDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.SQLException;

public class MyConnect {

    public static Connection conn = null;
    
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/quanlybantivi";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
            ex.printStackTrace();
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to database: " + conn.getCatalog());
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}
