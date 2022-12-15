package es.uem.desarrollofinal.proyectofinalivanyluis.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ControladorRootLayout {

    //Salir del programa
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }
    //Comportamiento del botón del menú de ayuda
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Informmacion del PROGRAMA");
        alert.setHeaderText("¡Esta es una aplicación JAVAFX de muestra para SWTESTACADEMY projects!, hecha por Luis Gómez e Iván Palomino");
        alert.setContentText("Puede buscar, eliminar, actualizar, insertar un nuevo empleado con este programa.");
        alert.show();
    }
}