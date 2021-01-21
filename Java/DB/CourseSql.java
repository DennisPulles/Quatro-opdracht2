package Java.DB;

public class CourseSql {
    
    //Create
    private String insertCourseSql(String input[]){
        return "INSERT INTO Course(CourseName, Subject, IntroductoryText, Difficulty) VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "')";
    }

    //Read
    private String selectCourseSql(String ID){
        return "SELECT * FROM Course WHERE CourseName = '" + ID + "'";
    }

    private String selectCoursesSql(String ID){
        return "SELECT * FROM Course";
    }

    //Update
    private String updateCourseSql(String ID, String input[]){
        return "UPDATE Course SET CourseName = '" + input[0] + "', Subject = '" + input[1] + "', IntroductoryText = '" + input[2] + "', Difficulty = '" + input[3] + "' WHERE CourseName = '" + ID + "'";
    }

    //Delete
    private String deleteCourseSql(String ID){
        return "DELETE FROM Course WHERE CourseName = '" + ID + "'";
    }
}
