package Java.DB;

public class StudentSql {

    //Create
    public String insertStudentSql(String input[]){
        return "INSERT INTO Student (StudentEmail, StudentName, StudentBirthdate, Gender, Address, City, Country, Zipcode) VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', '" + input[4] + "', '" + input[5] + "', '" + input[6] + "', '" + input[7] + "')";
    }

    //Read
    public String selectStudentsSql(){
        return "SELECT * FROM Student";
    }

    public String selectStudentSql(String ID){
        return "SELECT * FROM Student WHERE StudentEmail = '" + ID + "'";
    }

    //Update
    public String updateStudentSql(String ID, String input[]){
        return "UPDATE Student SET StudentEmail = '" + input[0] + "', StudentName = '" + input[1] + "', StudentBirthdate = '" + input[2] + "', Gender = '" + input[3] + "', Address = '" + input[4] + "', City = '" + input[5] + "', Country = '" + input[6] + "', Zipcode = '" + input[6] + " WHERE StudentEmail = ' " + ID + "'";
    }

    //Delete
    public String deleteStudentSql(String ID){
        return "DELETE FROM Student WHERE StudentEmail = " + ID + "'";
    }

}
