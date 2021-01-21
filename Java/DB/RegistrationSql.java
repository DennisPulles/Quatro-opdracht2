package Java.DB;

public class RegistrationSql {
    
    //create
    private String insertRegistrationSql(String input[]){
        return "INSERT INTO Registration(StudentEmail, CourseName, RegistrationDate) VALUES ('" + input[0] + "', '" + input[1] + "', GETDATE())";
    }

    //read
    private String selectRegistationsSql(){
        return "SELECT * FROM Registation";
    }

    //update
    private String updateRegistationSql(String input[]){
        return "UPDATE Registation SET StudentName = '" + input[0] + "', CourseName = '" + input[1] + "', CertificateID '" + input[2] + "'";
    }

    //delete
    private String deleteRegistrationSql(String Student, String Course){
        return "DELETE FROM Registration WHERE StudentEmail = '" + Student + "' && CourseName = '" + Course + "'";
    }
}
