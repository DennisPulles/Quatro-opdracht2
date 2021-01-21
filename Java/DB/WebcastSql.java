package Java.DB;

public class WebcastSql {
    
    //Create
    private String insertWebcastSql(String ID, String input[]){
        return "INSERT INTO Webcast(ContentItemID, TimeSpan, SpeakerName, Orginisation, URL) VALUES ('" + ID + "', '" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', )";
    }

    //Read
    private String selectWebcastSql(String ID){
        return "SELECT * FROM Webcast WHERE ContentItemID = '" + ID + "'";
    }

    private String selectWebcastsSql(){
        return "SELECT * from Webcast";
    }

    //Update
    private String updateWebcastSql(String ID, String input[]){
        return "UPDATE Webcast SET TimeSpan = '" + input[0] + "', SpeakerName ='" + input[1] + "', Orginisation, ='" + input[2] + "', URL ='" + input[3] + "' WHERE ContentItemID = '" + ID + "',";
    }

    //Delete
    private String deleteWebcastSql(String ID){
        return "DELETE FROM Webcast WHERE ContentItemID = '" + ID + "'";
    }
}
