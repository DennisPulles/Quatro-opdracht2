package Java.Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Java.DB.SqlManager;
import Java.DB.StudentSql;

public class Student {
    private String studentEmail;
    private String studentName;
    private String studentBirthdate;
    private String gender;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    protected ArrayList<Student> studentInfoArrayList;

    SqlManager manager = new SqlManager();
    StudentSql studentSql = new StudentSql();

    public Student(String studentEmail, String studentName, String studentBirthdate, String gender, String address,
            String city, String country, String postalCode) {
        this.studentInfoArrayList = new ArrayList<>();
        this.studentEmail = studentEmail;
        this.studentName = studentName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.studentBirthdate = studentBirthdate;
        this.gender = gender;

        // String studentEmail, String studentName, String adres, String city, String
        // country, String postalCode, String gender, String studentBirthdate

    }

    public void getStudentResult() {
        ResultSet studentRS = manager.executeSql(studentSql.selectStudentsSql());
        try {
            while (studentRS.next()) {
                Student student = new Student(studentRS.getString("StudentEmail"), studentRS.getString("StudentName"), studentRS.getString("StudentBirthdate"),studentRS.getString("Gender"),
                        studentRS.getString("Address"), studentRS.getString("City"),
                        studentRS.getString("Country"), studentRS.getString("Zipcode")
                        );
                        studentInfoArrayList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(String ID, String[] input){
        manager.executeSql(studentSql.updateStudentSql(ID, input));
    }

    public void insertStudent(String[] input){
        manager.executeSql(studentSql.insertStudentSql(input));
    }

    public void deleteStudent(String ID){
        manager.executeSql(studentSql.deleteStudentSql(ID));
    }

    public ArrayList<Student> getAllStudents(){
        return studentInfoArrayList;
    }

    public String getStudentEmail(){       
        return studentEmail;        
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentBirthdate() {
        return studentBirthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }



  

    // public static void main(String[] args) {
    //     Student student = new Student("Tde@as.as", "Tim", "15-01-2002", "Man", "AA", "BB", "CC", "2453AA");
    // } 
}
