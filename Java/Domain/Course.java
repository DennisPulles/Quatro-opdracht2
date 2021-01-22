package Java.Domain; 
 
import java.util.ArrayList; 
 
public class Course { 
    private String name; 
    private String subject; 
    private String introductoryText; 
    private String difficulty; 
    private ArrayList<Module> modules; 
    private ArrayList<Course> recommendedCourses; 
    private ArrayList<Student> student; 
 
    public Course(String name, String subject, String introductoryText, String difficulty, ArrayList<Module> modules, 
            ArrayList<Course> recommendedCourses, ArrayList<Student> student) { 
 
    } 
 
} 
