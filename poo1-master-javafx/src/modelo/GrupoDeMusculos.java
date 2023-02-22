package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_GRUPO_DE_MUSCULO")
public class GrupoDeMusculos {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;

  @Column(name = "ACTIVO")
  private Boolean activo;
  // un grupo de musculos está asociado a un ejercicio
  @OneToMany 
  private List<Ejercicio>  listaDeEjercicio = new ArrayList<>();




 // constructores
  public GrupoDeMusculos() {
  };

  

  
  

  // metodos


  public GrupoDeMusculos(String nombre) {
    this.nombre = nombre;
    this.activo = true;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Ejercicio> getListaDeEjercicio() {
    return listaDeEjercicio;
  }

  public void setListaDeEjercicio(Ejercicio e) {
    this.setListaDeEjercicio(e);
  }


  public String getNombre() {
    return this.nombre;
  };

  public void setNombre(String nombre) {
    this.nombre = nombre;

  };

  public String musculosDelGrupo() {
    return "Grupo: " + this.nombre;
  };

  public void setEjercicioNull(){
    this.listaDeEjercicio = null;
  }

  

public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

public boolean add(GrupoDeMusculos grupo) {
	return false;
}

public void remove(GrupoDeMusculos g) {
}

public boolean contains(GrupoDeMusculos g) {
	return false;
}
@Override
public String toString() {
  return "GrupoDeMusculos [listaDeEjercicio=" + listaDeEjercicio + ", nombre=" + nombre + "]";
} 
}