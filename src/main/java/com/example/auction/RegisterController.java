package com.example.auction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    public ComboBox comboBox;
    public Button registerButton;
    public TextField txtName;
    public TextField txtSurname;
    public TextField txtPassword;
    public TextField txtContact;
    public TextField txtAddress;
    public User user;

    public void registerButton(ActionEvent actionEvent) throws IOException {
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String password = txtPassword.getText();
        Long contact = Long.valueOf(txtContact.getText());
        String address = txtAddress.getText();


        User user = new User(name,surname,password,contact,address);
        switch(comboBox.getSelectionModel().getSelectedIndex()){
            case 0 -> user = new Farmer(name,surname,password,contact,address);
            case 1 -> user = new Millers(name,surname,password,contact,address);
            case 2 -> user = new FarmingAgency(name,surname,password,contact,address);
            case 3 -> user = new AgricultureAgency(name,surname,password,contact,address);
        }
        DatabaseConnection.addUser(user);
        //register();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Register Successful!");
        alert.setHeaderText("You have successfully registered");
        alert.setContentText("ID: "+user.getID()+" name: "+user.getName()+" password: "+user.getPassword()+" surname: "+user.getSurname()+
                " Contact no: "+user.getContactNo()+" address: "+user.getAddress());
        alert.showAndWait();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Stage stage  =new Stage();
        stage.setTitle("sa!");
        stage.setScene(scene);
        stage.show();
    }

    public void register(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Farmer","Miller","Farming Agency","Agriculture Agency");
        comboBox.getSelectionModel().select("Farmer");
    }

}
