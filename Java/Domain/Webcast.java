<<<<<<< Updated upstream
package Java.Domain; 

import java.sql.ResultSet;
import Java.DB.*;

public class Webcast extends ContentItems{ 
    private String title; 
    private int timeSpan; 
    private String description; 
    private String speakerName; 
    private String speakerCompany; 
    private String url; 
    private int amountWatched; 
 
    SqlManager manager = new SqlManager();
    WebcastSql webcastSql = new WebcastSql();

    ResultSet webcastsRS = manager.executeSql(webcastSql.selectWebcastsSql());

    while(webcastsRS.next()){
        Webcast name = new Webcast(webcastsRS.getString("Title"), webcastsRS.getInt("TimeSpan"), webcastsRS.getString("Discription"), webcastsRS.getString("SpeakerName"), webcastsRS.getString("Orginisation"), webcastsRS.getString("URL"), webcastsRS.getInt("AmountWatched"));
    }

    public Webcast(String title, int timeSpan, String description, String speakerName, String speakerCompany, String url, int amountWatched){ 
        this.title = title;
        this.timeSpan = timeSpan;
        this.description = description;
        this.speakerName = speakerName;
        this.url = url;
        this.amountWatched = amountWatched;
    } 
} 
=======
package Java.Domain;

public class Webcast extends ContentItems{
    private String tile;
    private int timeSpan;
    private String description;
    private String speakerName;
    private String speakerCompany;
    private String url;
    private int amountWatched;

    public Webcast(){
        
    }
}
>>>>>>> Stashed changes
