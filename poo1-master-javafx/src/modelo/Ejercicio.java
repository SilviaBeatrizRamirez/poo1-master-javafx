package modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_EJERCICIO")
public class Ejercicio {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;
  @Column(name = "TIEMPODEDESCANSO")
  private int tiempoDeDescanso;
  @Column(name = "REPETICIONE")
  private int repeticiones;
  @Column(name = "PESO")
  private double peso;
  @Column(name = "ACTIVO")
  private Boolean activo;

  // un ejercicio tiene muchos musculos
  @ManyToOne
  GrupoDeMusculos grupoDeMusculos;
  // un ejercicio pertenece a una semana
  @ManyToOne
  private SemanaDeEjercicio semana;

  // constructores
  public Ejercicio() {
  };

  public Ejercicio(String nombre, int tiempoDeDescanso, int repeticiones, double peso, GrupoDeMusculos grupoDeMusculos,
      SemanaDeEjercicio semana) {
    this.nombre = nombre;
    this.tiempoDeDescanso = tiempoDeDescanso;
    this.repeticiones = repeticiones;
    this.peso = peso;
    this.grupoDeMusculos = grupoDeMusculos;
    this.semana = semana;
    this.activo = true;
  }

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public void setSemanaDeEjercicio(SemanaDeEjercicio semana) {
    this.semana = semana;
  }

  public SemanaDeEjercicio getSemanaDeEjercicio() {
    return this.semana;
  }

  public boolean setgrupoDeMusculoss(GrupoDeMusculos grupo) {
    return this.grupoDeMusculos.add(grupo);
  }

  // metodos

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getTiempoDeDescanso() {
    return tiempoDeDescanso;
  }

  public void setTiempoDeDescanso(int tiempoDeDescanso) {
    this.tiempoDeDescanso = tiempoDeDescanso;
  }

  public int getRepeticiones() {
    return repeticiones;
  }

  public void setRepeticiones(int repeticiones) {
    this.repeticiones = repeticiones;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public GrupoDeMusculos getgrupoDeMusculos() {
    return grupoDeMusculos;
  }

  public void setgrupoDeMusculos(GrupoDeMusculos grupoDeMusculos) {
    this.grupoDeMusculos = grupoDeMusculos;
  }

  public SemanaDeEjercicio getSemana() {
    return semana;
  }

  public void setSemana(SemanaDeEjercicio semana) {
    this.semana = semana;
  }

  public String toString() {
    return this.nombre + " " + this.tiempoDeDescanso + "  " + this.repeticiones + " " + this.peso;
  }

  public void quitarGrupoMuscular(GrupoDeMusculos g) {
    if (this.grupoDeMusculos.contains(g)) {
      this.grupoDeMusculos.remove(g);
    }
  }

  public void removerGrupoMusculares() {
  }

  public void setSemanaNull() {
  }

public static void eliminarEjercicio(Ejercicio selectedItem) {
}
}
