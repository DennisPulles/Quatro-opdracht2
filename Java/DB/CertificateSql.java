package Java.DB;

public class CertificateSql {
    
    //create
    public String insertCertificateSql(String input[]){
        return "INSERT INTO Certificate(Grade, SignatoryName) VALUE ('" + input[0] + "', '" + input[1] + "')";
    }

    //read
    public String selectCertificateInRegistrationSql(){
        return "SELECT * FROM Certificate INNER JOIN Registration ON Certificate.CertificateID = Registration.CertificateID";
    }

    //update
    public String updateCertificateSql(String ID, String input[]){
        return "UPDATE Certificate SET Grade = '" + input[0] + "', SignatoryName = '" + input[1] + "' WHERE CertificateID = '" + ID + "'";
    }

    //delete
    public String deleteCertificateSql(String ID){
        return "DELETE FROM Certificate WHERE CertificateID = '" + ID + "'";
    }
}
