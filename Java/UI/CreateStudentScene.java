package Java.UI;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Gegevens");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label emailLabel = new Label("Email");
        emailLabel.setStyle("-fx-font-size:2em; ");
        grid.add(emailLabel, 0, 1);

        TextField userEmail = new TextField();
        userEmail.setPrefColumnCount(40);
        grid.add(userEmail, 1, 1);

        Label nameLabel = new Label("Voor & achternaam");
        nameLabel.setStyle("-fx-font-size:2em; ");
        grid.add(nameLabel, 0, 2);

        TextField userName = new TextField();
        grid.add(userName, 1, 2);

        Label houseNumber = new Label("Huisnummer");
        houseNumber.setStyle("-fx-font-size:2em; ");
        grid.add(houseNumber, 0, 3);

        TextField userHn = new TextField();
        grid.add(userHn, 1, 3);

        Label city = new Label("Stad");
        city.setStyle("-fx-font-size:2em; ");
        grid.add(city, 0, 4);

        TextField userCity = new TextField();
        grid.add(userCity, 1, 4);

        Label country = new Label("Land");
        country.setStyle("-fx-font-size:2em; ");
        grid.add(country, 0, 5);

        TextField userCountry = new TextField();
        grid.add(userCountry, 1, 5);

        Label zipcode = new Label("Postcode");
        zipcode.setStyle("-fx-font-size:2em; ");
        grid.add(zipcode, 0, 6);

        TextField userZipcode = new TextField();
        grid.add(userZipcode, 1, 6);

        Label gender = new Label("Geslacht");
        gender.setStyle("-fx-font-size:2em; ");
        grid.add(gender, 0, 7);

        final ComboBox userGender = new ComboBox();
        userGender.setPromptText("      ");
        userGender.getItems().addAll("Man", "Vrouw");
        GridPane.setConstraints(userGender, 1, 7);
        grid.getChildren().add(userGender);

        Label birthDate = new Label("Geboorte datum");
        birthDate.setStyle("-fx-font-size:2em; ");
        grid.add(birthDate, 0, 8);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker, 1, 8);

        Button button = new Button("Read Date");

        button.setOnAction(action -> {
            LocalDate value = datePicker.getValue();
        });

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(grid);
        hbox1.setAlignment(Pos.CENTER);
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 1em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());
        
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(backButton);

        BorderPane layout = new BorderPane();
        layout.setAlignment(hbox2, Pos.BOTTOM_LEFT);
        layout.setBottom(hbox2);
        layout.setCenter(hbox1);
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setStyle("-fx-background-color: #d6d6d6;");
        
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
