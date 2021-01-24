package Java.Domain; 

import java.sql.ResultSet;
import java.util.ArrayList;

import Java.DB.SqlManager;
import Java.DB.ModuleSql;

public class Module extends ContentItems{ 
    private String title; 
    private String version; 
    private int serialNumber; 
    private String description; 
    private String contactName; 
    private String contactEmail; 
    private ArrayList<Module> moduleInfo;
 
    //constructor for the module class
    public Module(String title, String version, int serialNumber, String description, String contactName, String contactEmail){ 
        this.title = title;
        this.version = version;
        this.serialNumber = serialNumber;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    //give this class access to the functions in SqlManager and ModuleSql
    SqlManager manager = new SqlManager();
    ModuleSql moduleSql = new ModuleSql();

    //Sql functions
    //get an arraylist of all Module in the database
    public void getModuleResult() {
        ResultSet moduleRS = manager.executeSql(moduleSql.selectModulesSql());
        try {
            while (moduleRS.next()) {
                //create new Module module
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertModule(String[] input, String ID){
        manager.executeSql(moduleSql.insertModuleSql(ID, input));
    }

    public void updateModule(String ID, String[] input){
        manager.executeSql(moduleSql.updateModuleSql(ID, input));
    }

    public void deleteModule(String ID){
        manager.executeSql(moduleSql.deleteModuleSql(ID));
    }

    //getters for all variables
    public ArrayList<Module> getModuleInfo(){
        return moduleInfo;
    }

    public String getTitle(){
        return title;
    }

    public String getVersion(){
        return version;
    }

    public int getSerialNumber(){
        return serialNumber;
    }

    public String getDescription(){
        return description;
    }

    public String getContactName(){
        return contactName;
    }

    public String getContactEmail(){
        return contactEmail;
    }
} 
