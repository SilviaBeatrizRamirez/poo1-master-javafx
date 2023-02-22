package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_SEMANA_DE_EJERCICIO")
public class SemanaDeEjercicio {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;
  //una semana tiene muchos ejercicios
  @OneToMany (mappedBy = "semana")
  private List<Ejercicio> listaDeEjercicios = new ArrayList<>();
  //una semana pertenece a un entrenamiento
  @ManyToOne
  Entrenamiento entrenamiento;

  //constructor
  public SemanaDeEjercicio(){}

  public SemanaDeEjercicio( String nombre){
     this.nombre = nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return this.nombre;
  }

  public void setEntrenamiento(Entrenamiento entrenamiento){
    this.entrenamiento = entrenamiento;
  }
  public Entrenamiento getEntrenamiento(){
    return this.entrenamiento;
  }
  public void setListEjercicio(Ejercicio ejercicio){
    this.listaDeEjercicios.add(ejercicio);
  }
  public List<Ejercicio> getEjercicio(Ejercicio ejercicio){
    return this.listaDeEjercicios;
  }
  public void sacarEjercicio(Ejercicio e){
    if(this.listaDeEjercicios.contains(e)){
      this.listaDeEjercicios.remove(e);
    }
  }

  //public  double VolumenSemanal(){}

}
