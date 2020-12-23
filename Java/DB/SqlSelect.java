package Java.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlSelect {
    
    //IMPORTANT CONNECTION INFO

    private String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Quatro;integratedSecurity=true;";

    // Connection manages information about the connection with the database.
    Connection con = null;

    // Statement allows us to execute SQL queries
    Statement stmt = null;

    // ResultSet is the table that the database returns.
    ResultSet rs = null;


    // SQL to get all content items of selected type
    public ResultSet selectContentItem(String type){

        try {
            // 'Import' the driver you downloaded
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create connection with the database.
            con = DriverManager.getConnection(connectionUrl);

            // Creating the SQL query
            String SQL = createSelectSql(type);
            
            stmt = con.createStatement();
            // Execute query on the database.
            rs = stmt.executeQuery(SQL);
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

    public String createSelectSql(String type){

        return "";
    }

    //inserting a new Course into the database
    //THE QUERY IS FINE, BUT THE METHODE IS STRUCTURED LIKE A SELECT METHODE
    // public void insertCourse(String[] data){

    //     try {
    //         // 'Import' the driver you downloaded
    //         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //         // Create connection with the database.
    //         con = DriverManager.getConnection(connectionUrl);

    //         // Creating the SQL query
    //         String SQL = "INSERT INTO Course (CourseName, Subject, IntroductoryText, Difficulty) VALUES (" + data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ")";
            
    //         stmt = con.createStatement();
    //         // Execute query on the database.
    //         rs = stmt.executeQuery(SQL);
    //     }
    //     // Handle any errors that may have occurred.
    //     catch (Exception e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (rs != null)
    //             try {
    //                 rs.close();
    //             } catch (Exception e) {
    //             }
    //         if (stmt != null)
    //             try {
    //                 stmt.close();
    //             } catch (Exception e) {
    //             }
    //         if (con != null)
    //             try {
    //                 con.close();
    //             } catch (Exception e) {
    //             }
    //     }
    // }
}
