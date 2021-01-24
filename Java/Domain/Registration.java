package Java.Domain;

import java.sql.ResultSet;
import java.util.ArrayList;

import Java.DB.SqlManager;
import Java.DB.RegistrationSql;

public class Registration {
    
    private String studentEmail;
    private String courseName;
    private String registrationDate;
    private int grade;
    private String signatory;
    private int certificateID;
    protected ArrayList<Registration> registrationInfo;

    public Registration(String studentEmail, String courseName, String registrationDate, int grade, String signatory, int certificateID){
        this.registrationInfo = new ArrayList<>();
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.grade = grade;
        this.signatory = signatory;
        this.certificateID = certificateID;
    }

    //give this class access to the functions in SqlManager and RegistrationSql
    SqlManager manager = new SqlManager();
    RegistrationSql registrationSql = new RegistrationSql();

    public void getRegistrationResult() {
        ResultSet registrationRS = manager.executeSql(registrationSql.selectRegistationsWithCertificateSql());
        try {
            while (registrationRS.next()) {
                Registration registration = new Registration(registrationRS.getString("StudentEmail"), registrationRS.getString("CourseName"), registrationRS.getString("RegistrationDate"), registrationRS.getInt("Grade"), registrationRS.getString("Signatory"), registrationRS.getInt("CertificateID"));
                registrationInfo.add(registration);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertRegistration(String[] input){
        manager.executeSql(registrationSql.insertRegistrationSql(input));
        //System.out.println(manager.executeSql(registrationSql.insertRegistrationSql(input)));
    }

    public void updateRegistraion(String[] input){
        manager.executeSql(registrationSql.updateRegistationSql(input));
        //System.out.println(manager.executeSql(registrationSql.updateRegistationSql(input)));
    }

    public void deleteRegistration(int certificateID){
        manager.executeSql(registrationSql.deleteRegistrationSql(certificateID));
        //System.out.println(manager.executeSql(registrationSql.deleteRegistrationSql(certificateID)));
    }

    public String getStudentEmail(){
        return studentEmail;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getRegistrationDate(){
        return registrationDate;
    }

    public int getGrade(){
        return grade;
    }

    public String getSignatory(){
        return signatory;
    }

    public int getCertificateID(){
        return certificateID;
    }
}
