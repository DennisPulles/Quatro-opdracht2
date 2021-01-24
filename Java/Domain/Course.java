package Java.Domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Java.DB.SqlManager;
import Java.DB.CourseSql;
 
public class Course { 
    private String name; 
    private String subject; 
    private String introductoryText; 
    private String difficulty; 
    protected ArrayList<Course> courseInfoArrayList;
    
    SqlManager manager = new SqlManager();
    CourseSql courseSql = new CourseSql();

    ResultSet coursesRS = manager.executeSql(courseSql.selectCoursesSql());

    public Course(String name, String subject, String introductoryText, String difficulty) {
        this.courseInfoArrayList = new ArrayList<>();
        this.name = name;
        this.subject = subject;
        this.introductoryText = introductoryText;
        this.difficulty = difficulty;
    }

    public void getCourseResult() {
        ResultSet courseRS = manager.executeSql(courseSql.selectCoursesSql());
        try {
            while (courseRS.next()) {
                Course course = new Course(courseRS.getString("CourseName"), courseRS.getString("Subject"), courseRS.getString("IntroductoryText"), courseRS.getString("Difficulty"));
                courseInfoArrayList.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    public void setIntroductoryText(String introductoryText) {
        this.introductoryText = introductoryText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Course> getCourseInfoArrayList() {
        return courseInfoArrayList;
    }

    public void setCourseInfoArrayList(ArrayList<Course> courseInfoArrayList) {
        this.courseInfoArrayList = courseInfoArrayList;
    }
   
} 