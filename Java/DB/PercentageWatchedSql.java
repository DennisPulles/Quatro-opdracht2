package Java.DB;

public class PercentageWatchedSql {
    
    //create
    private String insertPercentageWachtedSql(String student, String contentItem){
        return "INSERT INTO PercentageWachted(StudentEmail, ContentItemID, PercentageWatched) VALUE ('" + student + "', '" + contentItem+ "', 0)";
    }
    
    //read
    private String selectPercentageWatchedSql(String student, String contentItem){
        return "SELECT * FROM PercentageWatched WHERE StudentEmail = '" + student + "' && ContentItemID = '" + contentItem + "'";
    }

    //update
    private String updatePercentageWatchedSql(String student, String contentItem, int percentage){
        return "UPDATE PercentageWatched SET StudentEmail = '" + student + "', ContentItemID = '" + contentItem + "', PercentageWatched = '" + percentage + "'";
    }

    //delete
    private String deletePercentageWatchedSql(String student, String contentItem){
        return "DELETE FROM PercentageWatched WHERE StudentEmail = '" + student + "' && ContentItemID = '" + contentItem + "'";
    }
}
