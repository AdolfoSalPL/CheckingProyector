module com.example.proyectorchecking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectorchecking to javafx.fxml;
    exports com.example.proyectorchecking;
}