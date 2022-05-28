package com.example.auction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 575, 450);

        stage.setTitle("Welcome!");
        stage.setScene(scene);
        Image icon = new Image("file:bid.png");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        DatabaseConnection.createDB();
        DatabaseConnection.createDefaultTable();
        launch();
    }
}