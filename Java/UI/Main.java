package Java.UI;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 

public class Main extends Application { 
    public void start(Stage primaryStage) 
    { 
        primaryStage.setTitle("Codecademy"); 
  
        Menu data = new Menu("Data");
        Menu nieuw = new Menu("Nieuw");
        Menu wijzigen = new Menu("Wijzigen");
        Menu rapporten = new Menu("Rapport");

        // data
        MenuItem cursussen = new MenuItem("Cursussen");
        MenuItem cursisten = new MenuItem("Cursisten");
        MenuItem modules = new MenuItem("Modules");
        
        //nieuw
        MenuItem cursus = new MenuItem("Cursus");
        MenuItem module = new MenuItem("Module");
        MenuItem webcast = new MenuItem("Webcast");

        // rapporten
        MenuItem overzicht1 = new MenuItem("Overzicht 1");
        MenuItem overzicht2 = new MenuItem("Overzicht 2");
        MenuItem overzicht3 = new MenuItem("Overzicht 3");
        MenuItem overzicht4 = new MenuItem("Overzicht 4");
        MenuItem overzicht5 = new MenuItem("Overzicht 5");
        MenuItem overzicht6 = new MenuItem("Overzicht 6");

        data.getItems().add(cursussen); 
        data.getItems().add(cursisten); 
        data.getItems().add(modules); 
        nieuw.getItems().add(cursus);
        nieuw.getItems().add(module);
        nieuw.getItems().add(webcast);
        wijzigen.getItems().add(cursus);
        wijzigen.getItems().add(module);
        wijzigen.getItems().add(webcast);
        rapporten.getItems().add(overzicht1);
        rapporten.getItems().add(overzicht2);
        rapporten.getItems().add(overzicht3);
        rapporten.getItems().add(overzicht4);
        rapporten.getItems().add(overzicht5);
        rapporten.getItems().add(overzicht6);
  
        MenuBar menuBar = new MenuBar(); 
  
        menuBar.getMenus().add(data); 
        menuBar.getMenus().add(nieuw); 
        menuBar.getMenus().add(wijzigen); 
        menuBar.getMenus().add(rapporten); 

        VBox vb = new VBox(menuBar); 
  
        Scene sc = new Scene(vb, 960, 600); 
  
        primaryStage.setScene(sc); 
        primaryStage.setMaximized(true);
        primaryStage.show(); 
    } 
  
    public static void main(String args[]) 
    { 
        launch(args); 
    } 
} 

