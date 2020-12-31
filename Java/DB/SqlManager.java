package Java.DB;

import java.sql.Connection;
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

    private String type;

    private String query;

    private ResultSet select(String type, String ID){
        createSelectSql(type, ID);
        executeSql(query);
        return rs;
    }

    private ResultSet create(String type, String ID, String[] input){
        createInsertSql(type, input);
        executeSql(query);
        return rs;
    }
    
    // private String createSelectSql(String type, String ID){
    //     String attribute = "";
    //     String join = "";
    //     switch (type){
    //         case "Course":
    //             attribute = "CourseName";
    //             break;
    //         case "Student":
    //             attribute = "StudentEmail";
    //             break;
    //         case "ContentItem": 
    //             attribute = "ContentItemID";
    //             join = ""
    //     }
    //     query = "SELECT * FROM " + type + "WHERE " + attribute + " = " + ID;
    //     return query;
    // }

    private String createInsertSql(String type, String[] input){
        String columns = "";
        String values = "";
        switch (type){
            case "Student":
                columns = "(StudentEmail, StudentName, StudentBirthdate, Gender, Address, City, Country)";
                values = "(" + input[0] + ", " + input[1] + ", " + input[2] + ", " + input[3] + ", " + input[4] + ", " + input[5] + ", " + input[6] + ")";
                break;
            case "Course":
                columns = "(CourseName, Subject, IntroductoryText, Difficulty)";
                values = "(" + input[0] + ", " + input[1] + ", " + input[2] + ", " + input[3] + ")";
                break;
            case "Registration":
                columns = "(StudentEmail, CourseName, RegistrationDate, CertificateID)";
                values = "(" + input[0] + ", " + input[1] + ", " + input[2] + ", " + input[3] + ")"; 
                break;
            case "Certificate":
                columns = "(CourseName, RegistrationDate)";
                values = "(" + input[0] + ", " + input[1] + ")"; 
                break;                
        }
        query = "INSERT INTO " + type + " " + columns + " VALUES " + values;

        // for(String input: input){
        //     input + ", ";
        // }

        return query;
    }

    private String createUpdateSql(String type, String ID, String[] input){
        query = "UPDATE " + type + " SET";
        return query;
    }

    private String createDeleteSql(String type){
        query = "DELETE FROM " + type;
        return query;
    }

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