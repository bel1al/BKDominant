module com.dominant {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dominant to javafx.fxml;
    exports com.dominant;
}