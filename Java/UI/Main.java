package Java.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Codecademy");

        // Welcome text
        Label welcomeText = new Label("CodeCademy");
        welcomeText.setStyle("-fx-font-size:8em; ");

        // Button
        HBox hboxButtons = new HBox();
        Button courses = new Button("Cursussen");
        Button students = new Button("Cursisten");
        Button certificates = new Button("Certificaten");
        Button registrations = new Button("Registraties");
        hboxButtons.getChildren().addAll(courses, students, certificates, registrations);
        courses.setStyle("-fx-font-size: 2em; ");
        students.setStyle("-fx-font-size: 2em; ");
        certificates.setStyle("-fx-font-size: 2em; ");
        registrations.setStyle("-fx-font-size: 2em; ");
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(25);

        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setCenter(hboxButtons);

        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        primaryStage.setScene(sc);
        primaryStage.setMaximized(true);
        primaryStage.show();

        courses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseScene courseScene = new CourseScene();
                Stage scene2 = new Stage();
                try {
                    courseScene.start(scene2);
                    primaryStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });}

    public static void main(String args[]) {
        launch(args);
    }
}
