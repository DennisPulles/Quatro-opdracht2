package Java.UI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateCourseScene extends Application {

    @Override
    public void start(Stage creatCourseStage) throws Exception {
        creatCourseStage.setTitle("Codecademy");
        Label welcomeText = new Label("Cursus aanmaken");
        welcomeText.setStyle("-fx-font-size:8em; ");

        // Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labelling the input field
        Label courseNameLabel = new Label("Cursus naam: ");
        courseNameLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseNameLabel, 0, 0);
        grid.getChildren().add(courseNameLabel);

        Label courseSubjectLabel = new Label("Cursus onderwerp: ");
        courseSubjectLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseSubjectLabel, 0, 1);
        grid.getChildren().add(courseSubjectLabel);

        Label courseIntroductoryTextLabel = new Label("Cursus inleiding: ");
        courseIntroductoryTextLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseIntroductoryTextLabel, 0, 2);
        grid.getChildren().add(courseIntroductoryTextLabel);

        Label courseDifficultyLabel = new Label("Cursus niveau: ");
        courseDifficultyLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseDifficultyLabel, 0, 3);
        grid.getChildren().add(courseDifficultyLabel);

        // Defining the Name text field
        final TextField courseName = new TextField();
        courseName.setPromptText("Voer naam van cursus in.");
        courseName.setPrefColumnCount(10);
        courseName.getText();
        GridPane.setConstraints(courseName, 1, 0);
        grid.getChildren().add(courseName);

        // Defining the subject text field
        final TextField courseSubject = new TextField();
        courseSubject.setPromptText("Voer onderwerp in.");
        GridPane.setConstraints(courseSubject, 1, 1);
        grid.getChildren().add(courseSubject);

        // Defining the intro text field
        final TextArea introductoryText = new TextArea();
        introductoryText.setPrefColumnCount(40);
        introductoryText.setPromptText("Voer inleiding in.");
        GridPane.setConstraints(introductoryText, 1, 2);
        grid.getChildren().add(introductoryText);

        // Defining the difficulty text field
        final ComboBox courseDifficulty = new ComboBox();
        courseDifficulty.setPromptText("Niveau");
        courseDifficulty.getItems().addAll("Beginner", "Gevorderd", "Expert");
        GridPane.setConstraints(courseDifficulty, 1, 3);
        grid.getChildren().add(courseDifficulty);

        // Defining the Submit button
        Button submit = new Button("Aanmaken");
        submit.setStyle("-fx-background-color: #1da06a");
        GridPane.setConstraints(submit, 2, 0);
        grid.getChildren().add(submit);

        // Defining the Clear button
        Button clear = new Button("Leeg maken");
        clear.setStyle("-fx-background-color: #ff6633");
        GridPane.setConstraints(clear, 2, 1);
        grid.getChildren().add(clear);

        // Adding a Label to display a response
        final Label label = new Label();
        GridPane.setConstraints(label, 1, 4);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        // Putting the grid inside an HBox
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(grid);
        hbox1.setAlignment(Pos.CENTER);

        // Create a back button
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 2em; ");
        backButton.setLineSpacing(25);

        // Putting the backbutton inside hbox2
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(backButton);

        // Create a layout
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(hbox2, Pos.BOTTOM_LEFT);
        layout.setBottom(hbox2);
        layout.setAlignment(hbox1, Pos.CENTER);
        layout.setCenter(hbox1);

        // Start scene
        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        creatCourseStage.setScene(sc);
        creatCourseStage.setMaximized(true);
        creatCourseStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseScene courseScene = new CourseScene();
                Stage scene2 = new Stage();
                try {
                    courseScene.start(scene2);
                    creatCourseStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((introductoryText.getText() != null && !introductoryText.getText().isEmpty())
                        && (courseName.getText() != null && !courseName.getText().isEmpty())
                        && (courseSubject.getText() != null && !courseSubject.getText().isEmpty())
                        && (courseDifficulty.getValue() != null)) {
                    label.setText("Cursus, " + courseName.getText() + ", is aangemaakt.");
                } else {
                    if (courseDifficulty.getValue() == null) {
                        label.setText("U heeft geen niveau voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (introductoryText.getText().isEmpty()) {
                        label.setText("U heeft geen inleiding voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (courseSubject.getText().isEmpty()) {
                        label.setText("U heeft geen Onderwerp voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (courseName.getText().isEmpty()) {
                        label.setText("U heeft geen naam voor de cursus ingevoerd, probeer opnieuw.");
                    }
                }
            }
        });

        // Setting an action for the Clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                courseName.clear();
                courseSubject.clear();
                introductoryText.clear();
                label.setText(null);
            }
        });
    }
}