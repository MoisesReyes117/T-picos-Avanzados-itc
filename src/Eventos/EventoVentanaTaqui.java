package Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class EventoVentanaTaqui implements EventHandler {
    @Override
    public void handle(Event event) {
        Alert objAlert = new Alert (Alert.AlertType.CONFIRMATION);
        objAlert.setTitle("");
        objAlert.setHeaderText("");
        objAlert.setContentText("");
        objAlert.showAndWait();

    }
}
