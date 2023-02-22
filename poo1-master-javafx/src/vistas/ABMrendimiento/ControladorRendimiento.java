package vistas.ABMrendimiento;




import java.net.URL;
import java.util.ResourceBundle;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import modelo.Rendimiento;

public class ControladorRendimiento implements Initializable {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaFuerzaPU");
    EntityManager em = emf. createEntityManager();

    @FXML
    private TextField Rendimientos;

    @FXML
    private Button clikGuardar;

    @FXML
    private Button clikCambiar;
    @FXML

    private Button clikEliminar;
    @FXML
    private TextField tcRendimientos_alcanzado;

    @FXML
    private TextField tcPeso_alcanzado;

    @FXML
    private TableColumn <Rendimiento,Integer>tcRendimiento_alcanzaColumn;
    @FXML
    private TableView<Rendimiento>tvrendimientos;
   @ FXML
    private TableColumn<Rendimiento,Integer >tcPeso_acanzaTableColumn;

    @FXML
    void clicAgregar(ActionEvent event) {
       
        

        
        Rendimiento rendimiento = new Rendimiento (clikGuardar.getText());
        //System.out.println(Rendimientos.getText());

        em.getTransaction().begin();
        em.persist(rendimiento);
        em.getTransaction().commit();
        Rendimientos.clear();
        Rendimientos.requestFocus();
       
    }

    @FXML
    void funcionCargarTabla(Callback<TableColumn<Rendimiento, Integer>, TableCell<Rendimiento, Integer>> Rendimiento_alcanzado, Callback<TableColumn<Rendimiento, Integer>, TableCell<Rendimiento, Integer>> Peso_alcanzado){
        tcRendimiento_alcanzaColumn.setCellFactory(Rendimiento_alcanzado);
        tcPeso_acanzaTableColumn.setCellFactory(Peso_alcanzado);
  
        
    }
  

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       // botonGuardar.disableProperty()
                //.bind(Bindings.isEmpty(entradaTexto.textProperty()));        
    }

    //public void setLista(ObservableList<String> listaTarea) {
        //lista.setItems(listaTarea);
   // }


}
