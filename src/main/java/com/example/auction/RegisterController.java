package com.example.auction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    public void registerButton(ActionEvent actionEvent) {
        register();

    }
    public void register(){
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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Farmer","Miller","Farming Agency","Agriculture Agency");
        comboBox.getSelectionModel().select("Farmer");
    }
   
}
