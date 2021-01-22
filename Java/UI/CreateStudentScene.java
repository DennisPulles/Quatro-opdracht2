package Java.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateStudentScene extends Application {

    @Override
    public void start(Stage createStage) throws Exception {
        // TODO Auto-generated method stub
        createStage.setTitle("Codecademy");
        Label welcomeText = new Label("Aanmaken");
        welcomeText.setStyle("-fx-font-size:8em; ");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);


        Text scenetitle = new Text("Gegevens");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Voornaam");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Achternaam");
        grid.add(pw, 0, 2);

        TextField userTextField2 = new TextField();
        grid.add(userTextField2, 1, 2);
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(grid);
        hbox1.setAlignment(Pos.CENTER);

        Button backButton = new Button("Terug");
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(backButton);

        BorderPane layout = new BorderPane();
        layout.setAlignment(hbox2, Pos.BOTTOM_LEFT);
        layout.setBottom(hbox2);
        layout.setCenter(hbox1);
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        
        
       
        

        Scene sc = new Scene(layout, 960, 600, Color.BEIGE);

        createStage.setScene(sc);
        createStage.setMaximized(true);
        createStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                StudentsScene studentsScene = new StudentsScene();
                Stage scene2 = new Stage();
                try {
                    studentsScene.start(scene2);
                    createStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
