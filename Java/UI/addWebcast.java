package Java.UI;

public class addWebcast {

    private String name;
    private int timesPlayed;
    private String speaker;
    private int duration;

    public addWebcast(String name, int timesPlayed, String speaker, int duration) {
        this.name = name;
        this.timesPlayed = timesPlayed;
        this.speaker = speaker;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}