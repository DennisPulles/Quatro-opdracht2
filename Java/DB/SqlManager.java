package Java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SqlManager {
    
    //IMPORTANT CONNECTION INFO

    private String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Quatro;integratedSecurity=true;";

    // Connection manages information about the connection with the database.
    Connection con = null;

    // Statement allows us to execute SQL queries
    Statement stmt = null;

    // ResultSet is the table that the database returns.
    ResultSet rs = null;

    // executing the sql on the database with the allready created query
    private ResultSet executeSql(String query){

        try {
            // 'Import' the driver you downloaded
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create connection with the database.
            con = DriverManager.getConnection(connectionUrl);
            
            stmt = con.createStatement();
            // Execute query on the database.
            rs = stmt.executeQuery(query);
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
        return rs;
    }
}