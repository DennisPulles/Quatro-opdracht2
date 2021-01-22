package Java.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

import javafx.stage.Stage;

public class CourseScene extends Application {

    @Override
    public void start(Stage courseStage) throws Exception {
        courseStage.setTitle("Codecademy");

        Label welcomeText = new Label("Cursussen");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 2em; ");
        backButton.setLineSpacing(25);

        // Button to create a new course
        Button createCourseButton = new Button("Cursus aanmaken");
        createCourseButton.setStyle("-fx-font-size: 2em; ");

        // listview for all courses
        ListView listViewAll = new ListView();

        listViewAll.getItems().add("Item 1");
        listViewAll.getItems().add("Item 2");
        listViewAll.getItems().add("Item 3");
        listViewAll.getItems().add("Item 4");
        listViewAll.getItems().add("Item 5");
        listViewAll.getItems().add("Item 6");
        listViewAll.setPrefWidth(300);
        listViewAll.setMaxHeight(300);
        listViewAll.setStyle("-fx-font-size: 2em; -fx-padding: 2px; -fx-spacing: 10px");

        // Listview for top 3
        ListView listViewTop3 = new ListView();

        listViewTop3.getItems().add("Item 1");
        listViewTop3.getItems().add("Item 2");
        listViewTop3.getItems().add("Item 3");
        listViewTop3.setPrefWidth(300);
        listViewTop3.setMaxHeight(130);
        listViewTop3.setStyle("-fx-font-size: 2em; -fx-padding: 2px; -fx-spacing: 10px");

        // create a layout
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(listViewTop3, Pos.CENTER_RIGHT);
        layout.setRight(listViewTop3);
        layout.setAlignment(createCourseButton, Pos.CENTER_LEFT);
        layout.setLeft(createCourseButton);
        layout.setAlignment(listViewAll, Pos.CENTER);
        layout.setCenter(listViewAll);

        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        courseStage.setScene(sc);
        courseStage.setMaximized(true);
        courseStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    courseStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Button action for create course
        createCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateCourseScene CreateCourseScene = new CreateCourseScene();
                Stage scene2 = new Stage();
                try {
                    CreateCourseScene.start(scene2);
                    courseStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }
}