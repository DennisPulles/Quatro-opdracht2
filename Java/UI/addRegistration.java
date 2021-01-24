package Java.UI;

import java.sql.Date;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class addRegistration {

    private String studentEmail;
    private String courseName;
    private Date registrationDate;
    private Double grade;
    private CheckBox signature;
    private Button confirm;

    public addRegistration(String studentEmail, String courseName, Date registrationDate, Double grade) {
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.grade = grade;
        this.signature = new CheckBox();
        this.confirm = new Button("ok");
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public CheckBox getSignature() {
        return signature;
    }

    public void setSignature(CheckBox signature) {
        this.signature = signature;
    }

    public Button getConfirm() {
        return confirm;
    }

    public void setConfirm(Button confirm) {
        this.confirm = confirm;
    }

}
