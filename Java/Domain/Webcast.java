package Java.Domain;

import java.sql.ResultSet;
import java.util.ArrayList;

import Java.DB.SqlManager;
import Java.DB.WebcastSql;

public class Webcast extends ContentItems {
    private String title;
    private int timeSpan;
    private String description;
    private String speakerName;
    private String speakerCompany;
    private String url;
    private int amountWatched;
    protected ArrayList<Webcast> webcastInfoArrayList;

    SqlManager manager = new SqlManager();
    WebcastSql webcastSql = new WebcastSql();


    // Nieuwe code (nieuw is niet altijd beter)
    // public void getWebcastResult() {
    //     ResultSet webcastsRS = manager.executeSql(webcastSql.selectWebcastsSql());
    //     try {
    //         while (webcastsRS.next()) {
    //             Webcast name = new Webcast(webcastsRS.getString("Title"), webcastsRS.getInt("TimeSpan"),
    //                     webcastsRS.getString("Discription"), webcastsRS.getString("SpeakerName"),
    //                     webcastsRS.getString("Orginisation"), webcastsRS.getString("URL"),
    //                     webcastsRS.getInt("AmountWatched"));
    //         }
    //     } catch (Exception e) {
    //     }
    // }
    public void getWebcastResult() {
        ResultSet webcastRS = manager.executeSql(webcastSql.selectWebcastsSql());
        try {
            while (webcastRS.next()) {
                Webcast webcast = new Webcast(webcastRS.getString("Title"), webcastRS.getInt("TimeSpan"), webcastRS.getString("Discription"), webcastRS.getString("SpeakerName"), webcastRS.getString("Organisation"), webcastRS.getString("URL"), webcastRS.getInt("AmountWatched"));
                webcastInfoArrayList.add(webcast);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Webcast(String title, int timeSpan, String description, String speakerName, String speakerCompany,
            String url, int amountWatched) {
        this.webcastInfoArrayList = new ArrayList<>();
        this.title = title;
        this.timeSpan = timeSpan;
        this.description = description;
        this.speakerName = speakerName;
        this.url = url;
        this.amountWatched = amountWatched;
    }

    public String getTitle(){
        return title;
    }

    public int getTimeSpan(){
        return timeSpan;
    }

    public String getDescription(){
        return description;
    }

    public String getSpeakerName(){
        return speakerName;
    }

    public String getSpeakerCompany(){
        return speakerCompany;
    }

    public String getUrl(){
        return url;
    }

    public int getAmountWatched(){
        return amountWatched;
    }
}
