package Java.DB;

public class CertificateSql {
    
    //create
    private String insertCertificateSql(String input[]){
        return "INSERT INTO Certificate(Grade, SignatoryName) VALUE ('" + input[0] + "', '" + input[1] + "')";
    }

    //read
    // private String selectCertificateInRegistrationSql(String ID){
    //     return "SELECT * FROM";
    // }

    //update
    private String updateCertificateSql(String ID, String input[]){
        return "UPDATE Certificate SET Grade = '" + input[0] + "', SignatoryName = '" + input[1] + "' WHERE CertificateID = '" + ID + "'";
    }

    //delete
    private String deleteCertificateSql(String ID){
        return "DELETE FROM Certificate WHERE CertificateID = '" + ID + "'";
    }
}
