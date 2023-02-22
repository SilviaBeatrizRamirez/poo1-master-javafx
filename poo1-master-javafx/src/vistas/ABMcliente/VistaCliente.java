package vistas.ABMcliente;



import controlador.Controlador;
import javafx.scene.Parent;
import vistas.Vista;

public class VistaCliente implements Vista {

    //instancia del controlador para la vista
    //private final Controlador controlador;

    //constructor, recibe el controlador desde la vista principal app
    public VistaCliente(Controlador controlador){
        //this.controlador = controlador;
    };

    @Override
    public Parent obtenerVista() {
       
        return null;
    }
    
};
