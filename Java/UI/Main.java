package Java.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import javafx.stage.Stage;


public class Main extends Application { 
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Codecademy"); 

        Menu data = new Menu("Data");
        Menu add = new Menu("Nieuw");
        Menu modify = new Menu("Wijzigen");
        Menu overviews = new Menu("Rapport");

        // Data menu items
        MenuItem cursussen = new MenuItem("Cursussen");
        MenuItem cursisten = new MenuItem("Cursisten");
        MenuItem modules = new MenuItem("Modules");
        
        // New menu items
        MenuItem course = new MenuItem("Cursus");
        MenuItem module = new MenuItem("Module");
        MenuItem webcast = new MenuItem("Webcast");

        // Overview menu items
        MenuItem overview1 = new MenuItem("Overzicht 1");
        MenuItem overview2 = new MenuItem("Overzicht 2");
        MenuItem overview3 = new MenuItem("Overzicht 3");
        MenuItem overview4 = new MenuItem("Overzicht 4");
        MenuItem overview5 = new MenuItem("Overzicht 5");
        MenuItem overview6 = new MenuItem("Overzicht 6");

        data.getItems().add(cursussen); 
        data.getItems().add(cursisten); 
        data.getItems().add(modules); 
        add.getItems().add(course);
        add.getItems().add(module);
        add.getItems().add(webcast);
        modify.getItems().add(course);
        modify.getItems().add(module);
        modify.getItems().add(webcast);
        overviews.getItems().add(overview1);
        overviews.getItems().add(overview2);
        overviews.getItems().add(overview3);
        overviews.getItems().add(overview4);
        overviews.getItems().add(overview5);
        overviews.getItems().add(overview6);
  
        MenuBar menuBar = new MenuBar(); 
  
        menuBar.getMenus().add(data); 
        menuBar.getMenus().add(add); 
        menuBar.getMenus().add(modify); 
        menuBar.getMenus().add(overviews); 

        // Welcome text
        Text welcomeText = new Text("Welkom");

        // Button
        HBox hboxButtons = new HBox();
        Button courses = new Button("Cursussen");
        Button students = new Button("Cursisten");
        Button certificates = new Button("Certificaten");
        Button registrations = new Button("Registraties");
        hboxButtons.getChildren().addAll(courses, students, certificates, registrations);
        hboxButtons.setPadding(new Insets(400, 300, 300, 720));
        hboxButtons.setSpacing(25);
        

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(hboxButtons);
        

        Scene sc = new Scene(layout, 960, 600, Color.GREY); 

        primaryStage.setScene(sc); 
        primaryStage.setMaximized(true);
        primaryStage.show(); 
    } 
  
    public static void main(String args[]) 
    { 
        launch(args); 
    } 
} 