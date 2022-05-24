module com.example.auction {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.auction to javafx.fxml;
    exports com.example.auction;
}