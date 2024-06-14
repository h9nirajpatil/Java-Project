module com.example.cardriving {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cardriving to javafx.fxml;
    exports com.example.cardriving;
}