package Java.UI;

import java.security.Signature;
import java.sql.Date;
import java.util.ArrayList;

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
import javafx.scene.control.CheckBox;
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
        certificateView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        certificateView.setPrefSize(600, 400);

        // Make columns
        TableColumn<Registration, String> column1 = new TableColumn<>("Cursist");
        column1.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));
        TableColumn<Registration, String> column2 = new TableColumn<>("Cursus");
        column2.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        TableColumn<Registration, Date> column3 = new TableColumn<>("Registratie datum");
        column3.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        TableColumn<Registration, Double> column4 = new TableColumn<>("Beoordeling");
        column4.setCellValueFactory(new PropertyValueFactory<>("grade"));
        TableColumn<Registration, CheckBox> column5 = new TableColumn<>("Handtekening");
        column5.setCellValueFactory(new PropertyValueFactory<>("signature"));
        TableColumn<Registration, Button> column6 = new TableColumn<>("Bevestiging");
        column6.setCellValueFactory(new PropertyValueFactory<>("confirm"));

        // Add columns to table
        certificateView.getColumns().add(column1);
        certificateView.getColumns().add(column2);
        certificateView.getColumns().add(column3);
        certificateView.getColumns().add(column4);
        certificateView.getColumns().add(column5);
        certificateView.getColumns().add(column6);

        CheckBox checkBoxSignature = new CheckBox();
        String str = "2020-03-31";
        Date date = Date.valueOf(str);
        Button registrationConfirmButton = new Button("ok");

        ArrayList<addRegistration> arrayListCertificate = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Button button = new Button("ok");
            addRegistration addRegistration = new addRegistration("naam@student.avans.nl", "Java 101", date, 10.0,
                    new CheckBox(), button);
            certificateView.getItems().add(addRegistration);
            arrayListCertificate.add(addRegistration);
        }

        // Adding a Label to display a response
        final Label label = new Label();
        label.setStyle("-fx-font-size: 2em; ");
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(certificateView, label);
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
        for (addRegistration i : arrayListCertificate) {
            i.getConfirm().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    int c = 1;
                    for (addRegistration j : arrayListCertificate) {
                        if (i == j) {
                            if (i.getSignature().isSelected()) {
                                System.out.println("De certificatie (op positie " + c + ") is goedgekeurd en opgeslagen");
                                label.setText("De certificatie (op positie " + c + ") is goedgekeurd en opgeslagen");
                            } else {
                                System.out.println("Er is iets misgegaan");
                                label.setText("Er is iets misgegaan");
                            }
                        }
                        c++;
                    }
                }
            });
        }
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
