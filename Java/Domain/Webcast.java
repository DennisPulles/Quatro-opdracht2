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
    protected ArrayList<Webcast> topWebcasts;

    SqlManager manager = new SqlManager();
    WebcastSql webcastSql = new WebcastSql();

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

    public void getTopWebcastsResult() {
        ResultSet webcastRS = manager.executeSql(webcastSql.selectWebcastsTopSql());
        try {
            while (webcastRS.next()) {
                Webcast webcast = new Webcast(webcastRS.getString("Title"), webcastRS.getInt("TimeSpan"), webcastRS.getString("Discription"), webcastRS.getString("SpeakerName"), webcastRS.getString("Organisation"), webcastRS.getString("URL"), webcastRS.getInt("AmountWatched"));
                topWebcasts.add(webcast);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Webcast(String title, int timeSpan, String description, String speakerName, String speakerCompany,
            String url, int amountWatched) {
        this.webcastInfoArrayList = new ArrayList<>();
        this.topWebcasts = new ArrayList<>();
        this.title = title;
        this.timeSpan = timeSpan;
        this.description = description;
        this.speakerName = speakerName;
        this.url = url;
        this.amountWatched = amountWatched;
    }

    public ArrayList<Webcast> getAllWebcasts(){
        return webcastInfoArrayList;
    }

    public ArrayList<Webcast> getTopWebcasts(){
        return topWebcasts;
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
