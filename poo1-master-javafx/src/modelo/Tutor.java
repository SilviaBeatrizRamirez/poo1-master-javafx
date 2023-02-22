package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "T_TUTOR")
public class Tutor {
  @ Id
 private Integer dni;
  @Column(name = "NOMBRE")
  private String nombres;
  @Column(name = "APELLIDO")
  private String apellidos;
  @Column(name = "TELEFONO")
  private String telefono;
  //entrenamientos a cargo del tutor
  //@OneToMany (mappedBy = "tutor")
  @ManyToMany
  List<Entrenamiento> entrenamientos = new ArrayList<>();

  public Tutor() {
  };

  public Tutor(int dni, String nombres, String apellidos,   String telefono) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.dni = dni;
    this.telefono = telefono;

  };

  public String getnombres() {
    return this.nombres;
  }

  public void setnombres(String nombres) {
    this.nombres = nombres;
  }

  public String getapellidos() {
    return this.apellidos;
  }

  public void setapellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Integer getdni() {
    return this.dni;
  }

  public void setdni(Integer dni) {
    this.dni = dni;
  }
  public String gettelefono() {
    return this.telefono;

  }

  public void settelefono(String telefono) {
    this.telefono = telefono;
  }

  //dar entrenamientos al tutor
  public void setEntrenamiento(Entrenamiento entrenamiento) {
    this.entrenamientos.add(entrenamiento);
  };

  
  //lista de entrenamientos
  public List<Entrenamiento> getEntrenamiento() {
    return this.entrenamientos;
  }

  //eliminar entrenamiento
  public void removerEntrenamiento(Entrenamiento ent) {
    if (this.entrenamientos.contains(ent)) {
      this.entrenamientos.remove(ent);
    };
  }

  @Override
  public String toString() {
    return this.apellidos + " " + this.nombres + " " + this.dni + " "+ this.telefono;

  };

}
