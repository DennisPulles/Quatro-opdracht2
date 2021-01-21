package Java.DB;

public class ModuleCompletionSql {
    
    //create
    private String insertModuleCompletionSql(String certificate, String course){
        return "INSERT INTO ModuleCompletion(CertificateID, CourseName, PercentageCompleted) VALUE ('" + certificate + "', '" + course + "', 0)";
    }

    //read
    private String selectModuleCompletionSql(String certificate, String course){
        return "SELECT * FROM ModuleCompletion WHERE CertificateID = '" + certificate + "' && CourseName = '" + course + "'";
    }

    //update
    private String updateModuleCompletionSql(String certificate, String course, int grade){
        return "UPDATE ModuleCompletion SET CertificateID ='" + certificate + "', CourseName = '" + course + "', PercentageCompleted ='" + grade + "'";
    }

    //delete
    private String deleteModuleCompletionSql(String certificate, String course){
        return "DELETE FROM ModuleCompletion WHERE CertificateID = '" + certificate + "' && CourseName = '" + course + "'";
    }
}
