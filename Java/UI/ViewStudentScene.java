package Java.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewStudentScene extends Application {
    @Override
    public void start(Stage viewStudentStage) throws Exception {
        // TODO Auto-generated method stub
        viewStudentStage.setTitle("Codecademy");

        // Welcome text and back button
        Label welcomeText = new Label("Cursist");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        Label labelData = new Label("Gegevens");
        Label allCertificates = new Label("Behaalde certificaten");

        // Create Vboxes and Hboxes
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();


        // Listview for the student data
        ListView data = new ListView();
        data.getItems().add("a");
        vbox1.getChildren().addAll(labelData, data);

        // Listview for all the certificates
        ListView allCertificatesListView = new ListView();
        allCertificatesListView.getItems().add("a");
        

        // Listview for all the courses
        ListView courses = new ListView();
        courses.getItems().add("a");
        vbox2.getChildren().addAll(allCertificates, allCertificatesListView, courses);

        // Progressbars 
        ProgressBar pb1 = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);

        ProgressBar pb2 = new ProgressBar(0.6);
        ProgressIndicator pi2 = new ProgressIndicator(0.6);

        HBox progresBar1 = new HBox();
        progresBar1.getChildren().addAll(pb1, pi);
        Label modules = new Label("Modules");
        modules.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        VBox prog1 = new VBox();
        prog1.getChildren().addAll(modules, progresBar1);

        HBox progresBar2 = new HBox();
        progresBar2.getChildren().addAll(pb2, pi2);
        Label webcasts = new Label("Webcasts");
        webcasts.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        VBox prog2 = new VBox(webcasts, progresBar2);

        Button create = new Button("Aanmaken");

        vbox3.getChildren().addAll(prog1, prog2, create);
        vbox3.setSpacing(70);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(vbox1, vbox2, vbox3);
        hbox.setSpacing(150);
        hbox.setAlignment(Pos.CENTER);

        // Create a borderpane and add everything
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setCenter(hbox);
        layout.setStyle("-fx-background-color: #d6d6d6;");
        
        Scene sc = new Scene(layout, 960, 600);

        // Create a scene 
        
        viewStudentStage.setScene(sc);
        viewStudentStage.setMaximized(true);
        viewStudentStage.show();

        // Button to go back to the previous scene
        backButton.setStyle("-fx-font-size: 1em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());
        backButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    viewStudentStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
