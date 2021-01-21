package Java.DB;

public class CourseSql {
    
    private String createCoursesSql(String ID){
        return "SELECT * FROM Course WHERE CourseName = " + ID;
    }

    private String createCourseSql(String ID, String input[]){
        return "";
    }

}
