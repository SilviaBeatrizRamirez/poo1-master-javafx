package vistas.ABMtutor;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorTutor implements Initializable {

    @FXML
    private ListView<String> lista;

    @FXML
    private TextField entradaTexto;

    @FXML
    private Button botonGuardar;

    @FXML
    private Button botonCambiar;

    @FXML
    void clicGuardar(ActionEvent event) {
        lista.getItems().add(entradaTexto.getText());
        entradaTexto.clear();
        entradaTexto.requestFocus();
    }

    @FXML
    void clicCambiar(ActionEvent event) throws IOException {
        Stage stageEvento = (Stage) botonCambiar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controladorCliente/VistaCliente.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        //ControladorGrupoMuscular controlador = fxmlLoader.<ControladorGrupoMuscular>getController();
        //controlador.setLista(lista.getItems());
        Scene escena = new Scene(root);  
        stageEvento.setScene(escena);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        botonGuardar.disableProperty()
                .bind(Bindings.isEmpty(entradaTexto.textProperty()));        
    }

    public void setLista(ObservableList<String> listaTarea) {
        lista.setItems(listaTarea);
    }


}
