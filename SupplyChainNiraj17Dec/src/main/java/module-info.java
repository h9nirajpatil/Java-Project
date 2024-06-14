module com.example.supplychainniraj17dec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainniraj17dec to javafx.fxml;
    exports com.example.supplychainniraj17dec;
}