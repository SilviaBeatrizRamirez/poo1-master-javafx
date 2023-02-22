package vistas.ABMentrenamientos;




import java.net.URL;
import java.util.ResourceBundle;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Entrenamiento;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorEntrenamiento implements Initializable {
    
   
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaFuerzaPU");
    EntityManager em = emf. createEntityManager();

    ObservableList<Entrenamiento> entrenamientoLista = FXCollections.observableArrayList();

    
    
    
    @FXML
    private ListView<String> lista = new ListView<>();
    
   @FXML
    private Button btAgregar;

    @FXML
    private Button btEliminar;

    @FXML
    private Button btLimpiar;

    @FXML
    private Button btModificar;

    @FXML
    private TableColumn<Entrenamiento, String > tcEntrenamiento;

    @FXML
    private TextField tfEntrenamiento;

    @FXML
    private TableView<Entrenamiento> tvEntrenamientView;

    @FXML
    void clicAgregar(ActionEvent event) {
        lista.getItems().add(tfEntrenamiento.getText());
        
    
       
       Entrenamiento entrenamiento = new Entrenamiento();

       System.out.println( tfEntrenamiento.getText());

       em.getTransaction().begin();
       em.persist(entrenamiento);
       em.getTransaction().commit();

       tfEntrenamiento.clear();
       tfEntrenamiento.requestFocus();
    }

   @FXML

    void funcionCargarTabla (){
        
        tcEntrenamiento.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            

        
    }


    











    /* 
    @FXML
    void clicCambiar(ActinEvent event) throws IOException {
        Stage stageEvento = (Stage) botonCambiar.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controladorGrupoMuscular/vistaGrupoMuscular.fxml"));     
        Parent root = (Parent)fxmlLoader.load();
        //ControladorGrupoMuscular controlador = fxmlLoader.<ControladorGrupoMuscular>getController();
        //controlador.setLista(lista.getItems());
        Scene escena = new Scene(root);  
        stageEvento.setScene(escena);
    }*/

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       // botonGuardar.disableProperty()
           //     .bind(Bindings.isEmpty(entradaTexto.textProperty()));        
    }

   /*  public void setLista(ObservableList<String> listaTarea) {
        lista.setItems(listaTarea);
    }

    */

}
