package controlador;

import modelo.Cliente;
import modelo.GrupoDeMusculos;
import modelo.Rendimiento;
import modelo.SemanaDeEjercicio;
import modelo.Tutor;
import repositorios.Repositorio;
import modelo.Ejercicio;
import modelo.Entrenamiento;

public class Controlador {
    
    
    public Controlador() {
    }
    Repositorio repositorio;

    public Controlador(Repositorio rep) {
        this.repositorio = rep;
    }

    // INICIO CONTROLADOR DEL TUTOR ------------------------------------

    public Tutor nuevoTutor(int dni, String nombres, String apellidos, String telefono) {
        // iniciar transaccion
        this.repositorio.iniciarTransaccion();
        // crear un tutor
        Tutor t = new Tutor(dni, nombres, apellidos, telefono);
        // guardar el tutor en la BD con Repositorio
        this.repositorio.insertar(t);
        // cerrar la transaccion
        this.repositorio.confirmarTransaccion();
        return t;
    };

    public void modificarTutor(Tutor tutor, int dni, String nombres, String apellidos, String telefono) {
        this.repositorio.iniciarTransaccion();
        tutor.setdni(dni);
        tutor.setnombres(nombres);
        tutor.setapellidos(apellidos);
        tutor.settelefono(telefono);
        this.repositorio.insertar(tutor);
        this.repositorio.confirmarTransaccion();
    }

    public void eliminarTutor(Tutor t) {

        this.repositorio.iniciarTransaccion();
        this.repositorio.eliminar(t);
        this.repositorio.confirmarTransaccion();
    }


    // FINAL CONTROLADOR DEL TUTOR ------------------------------------

    // INICIO CONTROLADOR CLIENTE-------------------------------------

    public Cliente nuevoCliente(Integer dni, String nombres, String apellidos, String fechanacimiento, char sexo) {
        // inicio de la transacion

        this.repositorio.iniciarTransaccion();
        // crea el cliente
        Cliente c = new Cliente(dni, nombres, apellidos, fechanacimiento, sexo);
        // guarda el cliente en bd
        this.repositorio.insertar(c);
        // termina y cierra la transaccion
        this.repositorio.confirmarTransaccion();
        return c;
    };

    public void modificarnuevoCliente(Cliente cliente, Integer dni, String nombres, String apellidos,
            String fechanacimiento, char sexo) {
        this.repositorio.iniciarTransaccion();
        cliente.setdni(dni);
        cliente.setNombres(nombres);
        cliente.setApellido(apellidos);
        cliente.setfechanacimiento(fechanacimiento);
        cliente.setsexo(sexo);
        this.repositorio.insertar(cliente);
        this.repositorio.confirmarTransaccion();
    };

    public void eliminarCliente(Cliente c) {

        this.repositorio.iniciarTransaccion();
        this.repositorio.eliminar(c);
        this.repositorio.confirmarTransaccion();
    }

    // FINAL CONTROLADOR DEL CLIENTE-------------------------------------

    // INICIO CONTROLADOR GRUPO DE MUSCULOS
    public GrupoDeMusculos nuevoGrupoDeMusculo(String nombre) {
        this.repositorio.iniciarTransaccion();
        GrupoDeMusculos g = new GrupoDeMusculos(nombre);
        this.repositorio.insertar(g);
        this.repositorio.confirmarTransaccion();
        return g;
    }

    
    public void agregarEjercicioAlGrupoDeMusculo(GrupoDeMusculos g,Ejercicio e ){
        this.repositorio.iniciarTransaccion();
        g.setListaDeEjercicio(e);;
        this.repositorio.modificar(g);
        this.repositorio.confirmarTransaccion();
    } 

    public void modificarnuevoGrupoDeMusculo(GrupoDeMusculos grupo, String nombre) {
        this.repositorio.iniciarTransaccion();
        grupo.setNombre(nombre);
        this.repositorio.insertar(grupo);
        this.repositorio.confirmarTransaccion();
    }
 
    public void eliminarGrupoDeMusculo(GrupoDeMusculos grupo) {
        this.repositorio.iniciarTransaccion();
       // var j =  grupo.getListaDeEjercicio();

        grupo.setActivo(false);
      
        this.repositorio.confirmarTransaccion();

    } 
    // FINAL DEL CONTROLADOR

    // INICIO DE CONTROLADOR EJERCICIO
    public Ejercicio nuevoEjercicio(String nombre, int tiempoDeDescanso, int repeticiones, double peso, GrupoDeMusculos listaDeMusculo, SemanaDeEjercicio semana) {
        // iniciar transaccion
        this.repositorio.iniciarTransaccion();
        // crear un ejercicio
        Ejercicio e = new Ejercicio(nombre, tiempoDeDescanso, repeticiones, peso, listaDeMusculo,semana );
        // guardar el ejercicio en la BD con Repositorio
        this.repositorio.insertar(e);
        // cerrar la transaccion
        this.repositorio.confirmarTransaccion();
        return e;
    }

    public void modificarnuevoEjercicio(Ejercicio ejercicio, String nombre, int tiempoDeDescanso, int repeticiones,
            double peso) {
        this.repositorio.iniciarTransaccion();
        ejercicio.setNombre(nombre);
        ejercicio.setTiempoDeDescanso(tiempoDeDescanso);
        ejercicio.setRepeticiones(repeticiones);
        ejercicio.setPeso(peso);
        this.repositorio.insertar(ejercicio);
        this.repositorio.confirmarTransaccion();
    }

    public void eliminarEjercicio(Ejercicio ejercicio) {
        this.repositorio.iniciarTransaccion();
        ejercicio.setActivo(false);
        this.repositorio.confirmarTransaccion();
        
    } 
    // INICIA CONTROLADOR DE SEMANA DE EJERCICIOS

    public SemanaDeEjercicio nuevoSemanaDeEjercicio(String nombre) {
        this.repositorio.iniciarTransaccion();
        SemanaDeEjercicio semanas = new SemanaDeEjercicio(nombre);
        this.repositorio.insertar(semanas);
        this.repositorio.confirmarTransaccion();
        return semanas;
    }

    public void modificarnuevoSemanaDeEjercicio(SemanaDeEjercicio semana, String nombre) {
        this.repositorio.iniciarTransaccion();// falta ver como controlar que sean 4 semnas
        semana.setNombre(nombre);
        this.repositorio.insertar(semana);
        this.repositorio.confirmarTransaccion();
    }

    public  void eliminarSemanaDeEjercicio(SemanaDeEjercicio ejercicio){
        this.repositorio.iniciarTransaccion();
        this.repositorio.eliminar(ejercicio);
        this.repositorio.confirmarTransaccion();
    }
     
    public void agregarSemanaDeEjercicioAEjercicio(SemanaDeEjercicio s,Ejercicio e){
        this.repositorio.iniciarTransaccion();
        e.setSemanaDeEjercicio(s);
        this.repositorio.modificar(e);
        this.repositorio.confirmarTransaccion();
    } 
    //INICIO CONTROLADOR DE ENTRENAMIENTO 

    public Entrenamiento nuevoEntrnamiento(String semanadeinicio, String nombre){
        this.repositorio.iniciarTransaccion();

        Entrenamiento e = new Entrenamiento(semanadeinicio,nombre);
        this.repositorio.insertar(e);
        this.repositorio.confirmarTransaccion();
        return e;
    }
    public void modificarEntrenamiento(Entrenamiento e,String semanadeinicio, String nombre){
        this.repositorio.iniciarTransaccion();
        e.setSemanaDeInicio(semanadeinicio);
        e.setNombre(nombre);
        this.repositorio.insertar(e);
        this.repositorio.confirmarTransaccion();
    }
    public void eliminarEntrenamiento(Entrenamiento e){
        //iniciar transacion
        this.repositorio.iniciarTransaccion();
        //lista de clientes
        var clientes = e.getClientes();
        //foreach todos los clientes con entrenamiento pasan a null
        for (Cliente cliente : clientes) {
            cliente.setEntrenamientoNull();
            this.repositorio.modificar(cliente);
        }
        //vaciar clientes del array de entrenamiento
        e.removerTodosClientes();
        //eliminar entrenamiento
       this.repositorio.eliminar(e);
       this.repositorio.confirmarTransaccion();
    }

    public void  agregarClienteAlEntrenamiento(Cliente c,Entrenamiento e){
        this.repositorio.iniciarTransaccion();
        e.setClientesAlEntrenamiento(c);
        this.repositorio.modificar(e);
        this.repositorio.confirmarTransaccion();
    }

    public void agregarTutorAlEntrenamiento(Tutor t,Entrenamiento e){
        this.repositorio.iniciarTransaccion();
        e.setTutor(t);
        this.repositorio.modificar(e);
        this.repositorio.confirmarTransaccion();
    }

    public void agregarSemanaDeEjercicioAlEntrenamiento(SemanaDeEjercicio s,Entrenamiento e){
        this.repositorio.iniciarTransaccion();
        if(e.getListaDeSemana().size() < 4) {
            e.agregarSemanaDeEjercicio(s);
            s.setEntrenamiento(e);
        } else {
            System.out.println("maximo de semanas alcanzado");
            this.repositorio.descartarTransaccion();
        }
        this.repositorio.modificar(e);
        this.repositorio.modificar(s);
        this.repositorio.confirmarTransaccion();
    }


    public void agregarRendimientoDelCliente(Cliente cliente,Rendimiento r){
        this.repositorio.iniciarTransaccion();

        r.setCliente(cliente);
        this.repositorio.modificar(cliente);
        this.repositorio.confirmarTransaccion();
     }


    //INICIO CONTROLADOR RENDIMIENTO

    public Rendimiento nuevoRendimiento(int repeticionesRealizadas,double pesoAlcanzado){
        this.repositorio.iniciarTransaccion();

        Rendimiento r = new Rendimiento(repeticionesRealizadas, pesoAlcanzado);
        this.repositorio.insertar(r);
        this.repositorio.confirmarTransaccion();
        return r;
    }
    public void modificarRendimiento(Rendimiento r,int repeticionesRealizadas,double pesoAlcanzado){
        this.repositorio.iniciarTransaccion();
        r.setRepeticionesRealizadas(repeticionesRealizadas);
        r.setPesoAlcanzado(pesoAlcanzado);
        this.repositorio.insertar(r);
        this.repositorio.confirmarTransaccion();

    }
    public void eliminarRendimiento(Rendimiento R){
        this.repositorio.iniciarTransaccion();
        this.repositorio.eliminar(R);
        this.repositorio.confirmarTransaccion();
    }

}

