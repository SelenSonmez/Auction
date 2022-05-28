package com.example.auction;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public TextField txtID;
    public Button btnLogin;
    public PasswordField txtPassword;
    public static User user = null;

    public void loginbutton(){
        User user = login();
        if(user!=null){
            this.user = user;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful!");
            alert.setHeaderText("You have successfully logged in");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sessionSelection.fxml"));
            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.close();
            try {
                Scene scene = new Scene(fxmlLoader.load(), 645, 469);
                Stage stage  =new Stage();
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.show();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            String name = txtID.getText();
            String password = txtPassword.getText();
            if(name.equals("admin") && password.equals("admin")){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Stage loginStage = (Stage) btnLogin.getScene().getWindow();
                loginStage.close();
                try {
                    Scene scene = new Scene(fxmlLoader.load(), 600, 600);
                    Stage stage  =new Stage();
                    stage.setTitle("Register");
                    stage.setScene(scene);
                    stage.show();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("You could not log in.");
            alert.showAndWait();
        }
    }

    public User login(){
        String name = txtID.getText();
        String password = txtPassword.getText();
        if(name.equals("admin") && password.equals("admin")) return null;

        int id = Integer.parseInt(name);
        return DatabaseConnection.getUser(id,password);
    }
}
