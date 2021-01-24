package Java.Domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import Java.DB.SqlManager;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import Java.DB.CertificateSql;
import Java.DB.RegistrationSql;

public class Registration {

    private String studentEmail;
    private String courseName;
    private Date registrationDate;
    private double grade;
    private String signatory;
    private int certificateID;
    private Button confirmButton;
    private CheckBox signature;
    protected ArrayList<Registration> registrationInfo;

    public Registration(String studentEmail, String courseName, Date registrationDate, double grade, String signatory,
            int certificateID) {
        this.registrationInfo = new ArrayList<>();
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.grade = grade;
        this.signatory = signatory;
        this.certificateID = certificateID;
        this.signature = new CheckBox();
        this.confirmButton = new Button("ok");
    }

    // give this class access to the functions in SqlManager and RegistrationSql
    SqlManager manager = new SqlManager();
    RegistrationSql registrationSql = new RegistrationSql();
    CertificateSql certificateSql = new CertificateSql();

    public void getRegistrationResult() {
        ResultSet registrationRS = manager.executeSql(registrationSql.selectRegistationsWithCertificateSql());
        ResultSet certificateRS = manager.executeSql(certificateSql.selectCertificateInRegistrationSql());
        try {
            while (registrationRS.next() && certificateRS.next()) {
                Registration registration = new Registration(registrationRS.getString("StudentEmail"),
                        registrationRS.getString("CourseName"), registrationRS.getDate("RegistrationDate"),
                        certificateRS.getFloat("Grade"), certificateRS.getString("SignatoryName"),
                        certificateRS.getInt("CertificateID"));
                registrationInfo.add(registration);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertRegistration(String[] input) {
        manager.executeSql(registrationSql.insertRegistrationSql(input));
        // System.out.println(manager.executeSql(registrationSql.insertRegistrationSql(input)));
    }

    public void updateRegistraion(String[] input) {
        manager.executeSql(registrationSql.updateRegistationSql(input));
        // System.out.println(manager.executeSql(registrationSql.updateRegistationSql(input)));
    }

    public void deleteRegistration(int certificateID) {
        manager.executeSql(registrationSql.deleteRegistrationSql(certificateID));
        // System.out.println(manager.executeSql(registrationSql.deleteRegistrationSql(certificateID)));
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public double getGrade() {
        return grade;
    }

    public String getSignatory() {
        return signatory;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public ArrayList<Registration> getRegistrationInfo() {
        return registrationInfo;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public CheckBox getSignature() {
        return signature;
    }

}
