package Java.DB;

public class ContentItemSql {
    
    //Create
    private String insertContentItemSql(String input[]){
        return "INSERT INTO ContentItem(Status, PublicationDate, Title, Discription) VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "')";
    }

    //Update
    private String updateContentItemSql(String ID, String input[]){
        return "UPDATE ContentItem SET Status = '" + input[0] + "', Title = '" + input[1] + "',  Discription = '" + input[2] + " WHERE ContentItemID = '" + ID + "'";
    }

    //Delete
    private String deleteContentItemSql(String ID){
        return "DELETE FROM ContentItem WHERE ContentItemID = '" + ID + "'";
    }
}
