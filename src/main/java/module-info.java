module com.dominant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.dominant to javafx.fxml;
    exports com.dominant;
}