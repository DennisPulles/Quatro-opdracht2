package Java.DB;

public class ModuleSql {
    
    private String selectModuleSql(String ID){
        return "SELECT * FROM Module WHERE ContentItemID = " + ID;
    }

    private String selectModulesSql(String ID){
        return "SELECT * from Module";
    }

    private String createModuleSql(String ID){
        return "SELECT * FROM Module WHERE ContentItemID = " + ID;
    }

    private String updateModuleSql(String ID, String input[]){
        return "";
    }

}
