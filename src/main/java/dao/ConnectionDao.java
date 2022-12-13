package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ConnectionDao {
	public static Connection connectDB() throws SQLException, SQLTimeoutException, FileNotFoundException {  
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/dbpontoeletronico", 
                "root", "root"); 
        }
        catch (Exception message) { 
            System.out.println(message); 
        } 
        return connection; 
    } 
}