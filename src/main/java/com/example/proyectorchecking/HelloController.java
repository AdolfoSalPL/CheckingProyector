package com.example.proyectorchecking;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage stage; // Referencia al Stage

    // Setter para el Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Inicio de sesión exitoso");

            // Borrar el usuario y la contraseña
            usernameField.setText("");
            passwordField.setText("");

            // Cargar la nueva ventana
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Visualizacion.fxml"));
                Parent root = loader.load();
                Stage nuevaVentana = new Stage();
                nuevaVentana.setScene(new Scene(root));
                nuevaVentana.show();

                // Establecer la referencia al Stage de la nueva ventana
                HelloController nuevaVentanaController = loader.getController();
                nuevaVentanaController.setStage(nuevaVentana);

                // Cerrar la ventana actual
                if (stage != null) {
                    stage.close();
                } else {
                    System.out.println("No se puede cerrar la ventana actual porque el Stage es nulo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            usernameField.setText(""); // Limpiar el campo de usuario
            passwordField.setText(""); // Limpiar el campo de contraseña
        }
    }

    @FXML
    private void usernameFieldAction() {
        System.out.println("Se presionó Enter en el campo de usuario");
    }

    @FXML
    private void passwordFieldAction() {
        System.out.println("Se presionó Enter en el campo de contraseña");
    }

    @FXML
    private void closeButtonClicked() {
        // Cerrar la ventana actual
        if (stage != null) {
            stage.close();
        } else {
            System.out.println("No se puede cerrar la ventana actual porque el Stage es nulo.");
        }
    }
}