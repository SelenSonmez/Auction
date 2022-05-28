package com.example.auction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SessionSelection implements Initializable {
    public static int ID = 0;
    public TableColumn auctionID;
    public TableColumn auctionDate;
    public Button btnBack;
    @FXML
    private Button enterButton;

    @FXML
    private TableView<Auction> sessionTable;

    @FXML
    void enterButtonAction(ActionEvent event) {
        ID = sessionTable.getSelectionModel().getSelectedItem().getID();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("operation.fxml"));

        Stage sessionSelectionStage = (Stage) enterButton.getScene().getWindow();
        sessionSelectionStage.close();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 750, 584);
            Stage stage  =new Stage();
            stage.setTitle("Buy/Sell!");
            stage.setScene(scene);
            Image icon = new Image("file:bid.png");
            stage.getIcons().add(icon);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ID);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        sessionTable.getColumns().clear();

        auctionID = new TableColumn("Auction ID");
        auctionDate = new TableColumn("Auction Date");

        sessionTable.getColumns().addAll(auctionID,auctionDate);

        final ObservableList<Auction> data = FXCollections.observableArrayList(
                DatabaseConnection.getSessions()
        );

        auctionID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        auctionDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        for(Auction auction : data){
            sessionTable.getItems().add(auction);
        }
        //sessionTable.setItems(data);
    }

    public void btnBackAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));

        Stage sessionSelectionStage = (Stage) btnBack.getScene().getWindow();
        sessionSelectionStage.close();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 575, 450);
            Stage stage  =new Stage();
            stage.setTitle("Login!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


