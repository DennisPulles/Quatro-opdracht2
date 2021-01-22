package Java.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StudentsScene extends Application {

    @Override
    public void start(Stage studentStage) throws Exception {
        studentStage.setTitle("Codecademy");

        Label welcomeText = new Label("Curssisten");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");

        // Lsit view
        ListView listView = new ListView();

        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");
        listView.setPrefWidth(300);
listView.setPrefHeight(100);



        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(listView, Pos.CENTER_RIGHT);
        layout.setRight(listView);

        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        studentStage.setScene(sc);
        studentStage.setMaximized(true);
        studentStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    studentStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }); 

    }
    
}
