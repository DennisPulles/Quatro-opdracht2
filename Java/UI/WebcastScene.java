package Java.UI;

import java.util.ArrayList;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WebcastScene extends Application {
    @Override
    public void start(Stage webcastStage) throws Exception {
        // TODO Auto-generated method stub
        webcastStage.setTitle("Dennis Pulles(2153026), Guus Korbijn(2168557), Tim de Laater(2171083) & Wouter Zegers(2172665)");

        Label welcomeText = new Label("Webcasts");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        Label top3Webcasts = new Label("Top 3 webcasts");
        top3Webcasts.setStyle("-fx-font-size:2em; ");
        Label allWebcasts = new Label("Alle webcasts");
        allWebcasts.setStyle("-fx-font-size:2em; ");

        // Table view all webcasts
        TableView tableViewAllWebcasts = new TableView();
        tableViewAllWebcasts.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableViewAllWebcasts.setPrefSize( 600, 600 );
        
        // Make columns 
        TableColumn<Webcast, String> column1 = new TableColumn<>("Naam");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Webcast, Integer> column2 = new TableColumn<>("Aantal keren bekijken");
        column2.setCellValueFactory(new PropertyValueFactory<>("timesPlayed"));
        TableColumn<Webcast, String> column3 = new TableColumn<>("Spreker");
        column3.setCellValueFactory(new PropertyValueFactory<>("speaker"));
        TableColumn<Webcast, Integer> column4 = new TableColumn<>("Duur in minuten");
        column4.setCellValueFactory(new PropertyValueFactory<>("duration"));

        // Add columns to table
        tableViewAllWebcasts.getColumns().add(column1);
        tableViewAllWebcasts.getColumns().add(column2);
        tableViewAllWebcasts.getColumns().add(column3);
        tableViewAllWebcasts.getColumns().add(column4);

        // Add webcasts to table
       
        Webcast webcast = new Webcast("a",0,"a", "a", "a", "a", 0);
        webcast.getWebcastResult();
        ArrayList<Webcast> list = webcast.getAllWebcasts();

        for (Webcast x : list) {
            tableViewAllWebcasts.getItems().add(x.getTitle());
        }
      



        // Table view webcasts top 3
        TableView tableViewWebcastsTop3 = new TableView();
        tableViewWebcastsTop3.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableViewWebcastsTop3.setPrefSize( 600, 103 );

        // Make columns 
        TableColumn<Webcast, String> column1Top3 = new TableColumn<>("Naam");
        column1Top3.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Webcast, Integer> column2Top3 = new TableColumn<>("Aantal keren bekeken");
        column2Top3.setCellValueFactory(new PropertyValueFactory<>("timesPlayed"));
        TableColumn<Webcast, String> column3Top3 = new TableColumn<>("Spreker");
        column3Top3.setCellValueFactory(new PropertyValueFactory<>("speaker"));
        TableColumn<Webcast, Integer> column4Top3 = new TableColumn<>("Duur in minuten");
        column4Top3.setCellValueFactory(new PropertyValueFactory<>("duration"));

        // Add columns to table
        tableViewWebcastsTop3.getColumns().add(column1Top3);
        tableViewWebcastsTop3.getColumns().add(column2Top3);
        tableViewWebcastsTop3.getColumns().add(column3Top3);
        tableViewWebcastsTop3.getColumns().add(column4Top3);

        // Add top 3 webcasts to table
        tableViewWebcastsTop3.getItems().add(new addWebcast("Guus", 30, "Guus", 45));
        tableViewWebcastsTop3.getItems().add(new addWebcast("Guus", 20, "Guus", 45));
        tableViewWebcastsTop3.getItems().add(new addWebcast("Guus", 10, "Guus", 45));

        VBox tableViewAllWebcastsVbox = new VBox();
        tableViewAllWebcastsVbox.getChildren().addAll(allWebcasts, tableViewAllWebcasts);
        tableViewAllWebcastsVbox.setSpacing(10);

        VBox tableViewWebcastsTop3VBox = new VBox();
        tableViewWebcastsTop3VBox.getChildren().addAll(top3Webcasts, tableViewWebcastsTop3);
        tableViewWebcastsTop3VBox.setSpacing(10);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(tableViewAllWebcastsVbox, tableViewWebcastsTop3VBox);
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(hbox, Pos.CENTER_LEFT);
        layout.setCenter(hbox);
        
        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        layout.setStyle("-fx-background-color: #B4B4B4;");
        webcastStage.setScene(sc);
        webcastStage.setMaximized(true);
        webcastStage.show();

        backButton.setStyle("-fx-font-size: 1em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());
        backButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    webcastStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
