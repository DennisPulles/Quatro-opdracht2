package Java.UI;

import java.security.Signature;
import java.sql.Date;
import java.util.ArrayList;

import Java.Domain.Certificate;
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

        // Add columns to table
        certificateView.getColumns().add(column1);
        certificateView.getColumns().add(column2);
        certificateView.getColumns().add(column3);
        certificateView.getColumns().add(column4);
        certificateView.getColumns().add(column5);

        CheckBox checkBoxSignature = new CheckBox();
        String str = "2020-03-31";
        Date date = Date.valueOf(str);
        Button registrationConfirmButton = new Button("ok");

        Registration registration = new Registration("", "", date, 0, "", 0);
        registration.getRegistrationResult();
        ArrayList<Registration> registrationList = registration.getRegistrationInfo();

        // Create a row for every entry in the table and add its information to the
        // right spot
        for (Registration x : registrationList) {
            if (!x.getSignature().isSelected()) {
                certificateView.getItems().add(new addRegistration(x.getStudentEmail(), x.getCourseName(),
                        x.getRegistrationDate(), x.getGrade()));
            }
        }
        // Button to confirm
        Button button = new Button("Confirm");
        button.setStyle("-fx-font-size: 2em; ");

        // Adding a Label to display a response
        final Label label = new Label();
        label.setStyle("-fx-font-size: 2em; ");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(certificateView, button, label);
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

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                boolean itemsChecked = false;
                for (Registration i : registrationList) {
                    if (i.getSignature().isSelected()) {
                        label.setText("De certificatie (van " + i.getStudentEmail() + ") is goedgekeurd en opgeslagen");
                        itemsChecked = true;
                    } else { 
                    }
                    System.out.println(i);
                }
                if (itemsChecked) {
                } else {
                    label.setText("Er is iets misgegaan");
                }
            }
        });
        // while (true) {
        // for (Registration i : registrationList) {
        // System.out.println("index van " + certificateView.getSelectionModel() + " is
        // "
        // + certificateView.getSelectionModel().getSelectedIndex());
        // registrationList.get((certificateView.getSelectionModel().getSelectedIndex())
        // + 1).getConfirmButton()
        // .setOnAction(new EventHandler<ActionEvent>() {
        // @Override
        // public void handle(ActionEvent e) {
        // int c = 1;
        // for (Registration j : registrationList) {
        // if (i == j) {
        // if
        // (registrationList.get(certificateView.getSelectionModel().getSelectedIndex())
        // .getSignature().isSelected()) {
        // System.out.println("De certificatie (op positie " + c
        // + ") is goedgekeurd en opgeslagen");
        // label.setText("De certificatie (op positie " + c
        // + ") is goedgekeurd en opgeslagen");
        // } else {
        // System.out.println("Er is iets misgegaan");
        // label.setText("Er is iets misgegaan");
        // }
        // }
        // c++;
        // }
        // }
        // });
        // }
        // }
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
