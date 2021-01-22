package Java.Domain; 

import java.util.ArrayList;

import java.sql.ResultSet;
import Java.DB.*; 
 
public class Course { 
    private String name; 
    private String subject; 
    private String introductoryText; 
    private String difficulty; 
    private ArrayList<Module> modules; 
    private ArrayList<Course> recommendedCourses; 
    private ArrayList<Student> student; 
    
    SqlManager manager = new SqlManager();
    CourseSql courseSql = new CourseSql();

    ResultSet coursesRS = manager.executeSql(courseSql.selectCoursesSql());
    
    public Course(String name, String subject, String introductoryText, String difficulty, ArrayList<Module> modules, ArrayList<Course> recommendedCourses, ArrayList<Student> student) { 
        
    }
} 
