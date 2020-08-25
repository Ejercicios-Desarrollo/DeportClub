package domain;

import domain.motivaciones.Motivacion;
import domain.rutina.DiaEntrenamiento;
import domain.rutina.DiaEntrenamientoEjercicio;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.EjercicioSimple;
import domain.rutina.ejercicios.EjercicioSimpleAsignacion;
import domain.rutina.registro.EjercicioSimpleRegistro;
import domain.trofeos.DeportistaTrofeo;
import domain.trofeos.Trofeo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deportista")
public class Deportista extends Persistente{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaDeNacimiento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "altura")
    private Float altura;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deportista_id")
    private List<Motivacion> motivaciones;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deportista_id")
    private List<Rutina> rutinas;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deportista")
    private List<DeportistaTrofeo> deportistaTrofeos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deportista_id")
    private List<PesoRegistro> pesoRegistros;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "deportista_id")
    private List<NivelGrasaMusculoRegistro> nivelGrasaMusculoRegistros;

    public Deportista(){

    }

    public Deportista(String nombre, String apellido,
                      Sexo sexo, Float altura){
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.altura = altura;
        this.motivaciones = new ArrayList<>();
        this.rutinas = new ArrayList<>();
        this.deportistaTrofeos = new ArrayList<>();
        this.pesoRegistros = new ArrayList<>();
        this.nivelGrasaMusculoRegistros = new ArrayList<>();
    }

    public void pesarse(Float peso){
        agregarPesoRegistro(peso);
    }

    public void medirNivelesGrasaMusculo(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        agregarNivelGrasaMusculoRegistro(nivelDeGrasa, nivelDeMasaMuscular);
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Float getAltura() {
        return altura;
    }

    public void agregarRutina(Rutina rutina){
        this.rutinas.add(rutina);
    }

    public Float getUltimoPeso() {
        PesoRegistro ultimoPesoRegistro = this.pesoRegistros.get(pesoRegistros.size() - 1);
        return ultimoPesoRegistro.getPeso();
    }

    public Rutina getUltimaRutina() {
        Rutina ultimaRutina = this.rutinas.get(rutinas.size() - 1);
        return ultimaRutina;
    }

    public Float getUltimoNivelDeGrasa() {
        NivelGrasaMusculoRegistro ultimoNivelGrasaMusculoRegistro = this.nivelGrasaMusculoRegistros.get(nivelGrasaMusculoRegistros.size() - 1);
        return ultimoNivelGrasaMusculoRegistro.getNivelDeGrasa();
    }

    public Float getUltimoNivelDeMasaMuscular() {
        NivelGrasaMusculoRegistro ultimoNivelGrasaMusculoRegistro = this.nivelGrasaMusculoRegistros.get(nivelGrasaMusculoRegistros.size() - 1);
        return ultimoNivelGrasaMusculoRegistro.getNivelDeMasaMuscular();
    }

    public Motivacion getUltimaMotivacion() {
        Motivacion motivacion = this.motivaciones.get(motivaciones.size() - 1);
        return motivacion;
    }

    public void agregarNivelGrasaMusculoRegistro(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        this.nivelGrasaMusculoRegistros.add(new NivelGrasaMusculoRegistro(nivelDeGrasa, nivelDeMasaMuscular));
    }

    public void agregarPesoRegistro(Float peso){
        this.pesoRegistros.add(new PesoRegistro(peso));
    }

    public void agregarMotivacion(Motivacion motivacion){
        this.motivaciones.add(motivacion);
    }

    public void agregarTrofeo(Trofeo trofeo){
        this.deportistaTrofeos.add(new DeportistaTrofeo(this, trofeo));
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void realizarEjercicio(DiaEntrenamientoEjercicio diaEntrenamientoEjercicio,
                                  Float peso, Integer series, Integer repeticiones) {
        diaEntrenamientoEjercicio.realizarEjercicio(peso, series, repeticiones);
    }
}
