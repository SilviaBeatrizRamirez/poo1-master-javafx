package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CLIENTE")
public class Cliente {

  // private static final string Entrenamiento = null;
  @Id
  private Integer dni;
  @Column(name = "NOMBRE")
  private String nombres;
  @Column(name = "APELLIDO")
  private String apellidos;
  @Column(name = "FECHA_DE_NACIMIENTO")
  private String fechanacimiento;
  @Column(name = "SEXO")
  private char sexo;
  // entrenamiento
  // falta get y set.
  @ManyToOne
  Entrenamiento entrenamiento;
  @OneToMany (mappedBy = "cliente")
  private List<Rendimiento> rendimiento = new ArrayList<>();

  public Cliente() {
  }

  public Cliente(Integer dni, String nombres, String apellidos, String fechanacimiento, char sexo) {
    this.nombres = nombres;
    this.sexo = sexo;
    this.dni = dni;
    this.apellidos = apellidos;
    this.fechanacimiento = fechanacimiento;
  }

  public <alertType> Cliente(alertType tipo) {
  }

  public void setsexo(char sexo) {
    this.sexo = sexo;
  }

  public char getsexo() {
    return this.sexo;
  }

  public Integer getdni() {
    return this.dni;
  };

  public void setdni(Integer dni) {
    this.dni = dni;
  }

  public String getnombres() {
    return this.nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public void setApellido(String apellido) {
    this.apellidos = apellido;
  }

  public String getFechanaciemiento() {
    return this.fechanacimiento;
  }

  public void setfechanacimiento(String fechanacimiento) {
    this.fechanacimiento = fechanacimiento;

  };

  public String getApellido() {
    return this.apellidos;
  }

  // asignar entrenamiento al cliente
  public void setEntrenamiento(Entrenamiento entrenamiento) {
    this.entrenamiento = entrenamiento;
  };

  // ver el entrenamiento del cliente
  public Entrenamiento getEntrenamiento() {
    return this.entrenamiento;
  };

  public void setEntrenamientoNull() {
    this.entrenamiento = null;
  }

  //NO FUNCIONA ESTA CLASE 
  public void setRendimiento(Rendimiento rendimiento){
    this.rendimiento.add(rendimiento);
  }
  public  List<Rendimiento> getRendimiento(){
    return this.rendimiento;
  }
  public void setRendimiento(){
    this.rendimiento = null;
  }

  @Override
  public String toString() {
    return this.nombres + " " + this.apellidos + " " + this.dni + " "
        + this.sexo + " " + this.fechanacimiento;
  }

};