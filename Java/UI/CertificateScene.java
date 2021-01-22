package Java.UI;

import java.security.Signature;
import java.sql.Date;

import Java.Domain.Course;
import Java.Domain.Registration;
import Java.Domain.Student;
import Java.Domain.Webcast;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CertificateScene extends Application {

    @Override
    public void start(Stage certificateStage) throws Exception {
        // TODO Auto-generated method stub
        certificateStage.setTitle("Codecademy");

        Label welcomeText = new Label("Certificaat afronden");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");

        // Table view all webcasts
        TableView certificateView = new TableView();
        certificateView.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        certificateView.setPrefSize( 600, 400 );



        
        // Make columns 
        TableColumn<Student, String> column1 = new TableColumn<>("Cursist");
        column1.setCellValueFactory(new PropertyValueFactory<>("XXX"));
        TableColumn<Course, String> column2 = new TableColumn<>("Cursus");
        column2.setCellValueFactory(new PropertyValueFactory<>("XXX"));
        TableColumn<Registration, Date> column3 = new TableColumn<>("Registratiedatum");
        column3.setCellValueFactory(new PropertyValueFactory<>("XXX"));
        // TableColumn<Grade, Integer> column4 = new TableColumn<>("Beoordeling");
        // column4.setCellValueFactory(new PropertyValueFactory<>("XXX"));
        // TableColumn<Signature, Integer> column5 = new TableColumn<>("Handtekening");
        // column5.setCellValueFactory(new PropertyValueFactory<>("XXX"));
        // TableColumn<Confirm, Integer> column6 = new TableColumn<>("Bevestiging");
        // column6.setCellValueFactory(new PropertyValueFactory<>("XXX"));

        // Add columns to table
        certificateView.getColumns().add(column1);
        certificateView.getColumns().add(column2);
        certificateView.getColumns().add(column3);
        // certificateView.getColumns().add(column4);
        // certificateView.getColumns().add(column5);
        // certificateView.getColumns().add(column6);

        

        VBox vbox = new VBox();
        vbox.getChildren().addAll(certificateView);
        vbox.setSpacing(100);

        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(vbox, Pos.CENTER);
        layout.setCenter(vbox);
        
        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        certificateStage.setScene(sc);
        certificateStage.setMaximized(true);
        certificateStage.show();

        backButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    certificateStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    
}
