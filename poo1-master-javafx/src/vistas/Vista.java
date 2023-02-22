package vistas;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//interfaz Vista, metodo de alerta y obtener vista.
public interface Vista {
    public Parent obtenerVista();

    public default void mostrarAlerta(AlertType tipo, String titulo, String cabecera, String mensaje) {
        // mostramos una alerta
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(cabecera);
        a.setContentText(mensaje);
        a.show();
    }
}
