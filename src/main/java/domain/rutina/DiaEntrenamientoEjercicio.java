package domain.rutina;

import domain.Persistente;
import domain.rutina.ejercicios.Ejercicio;
import domain.rutina.ejercicios.EjercicioSimple;
import domain.rutina.ejercicios.EjercicioSimpleAsignacion;
import domain.rutina.registro.EjercicioSimpleRegistro;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dia_entrenamiento_ejercicio")
public class DiaEntrenamientoEjercicio extends Persistente {
    @ManyToOne
    @JoinColumn(name = "dia_entrenamiento_id")
    private DiaEntrenamiento diaEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dia_entrenamiento_ejercicio_id")
    private List<EjercicioSimpleAsignacion> ejerciciosAsignaciones;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dia_entrenamiento_ejercicio_id")
    private List<EjercicioSimpleRegistro> ejerciciosRegistro;

    public DiaEntrenamientoEjercicio(){
        this.ejerciciosAsignaciones = new ArrayList<>();
        this.ejerciciosRegistro = new ArrayList<>();
    }

    public DiaEntrenamientoEjercicio(DiaEntrenamiento diaEntrenamiento, Ejercicio ejercicio){
        this.diaEntrenamiento = diaEntrenamiento;
        this.ejercicio = ejercicio;
        this.ejerciciosAsignaciones = new ArrayList<>();
        this.ejerciciosRegistro = new ArrayList<>();
    }

    public DiaEntrenamiento getDiaEntrenamiento() {
        return diaEntrenamiento;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public List<EjercicioSimpleAsignacion> getEjerciciosAsignaciones() {
        return ejerciciosAsignaciones;
    }

    public List<EjercicioSimpleRegistro> getEjerciciosRegistro() {
        return ejerciciosRegistro;
    }

    public void agregarEjercicioSimpleRegistro(EjercicioSimpleRegistro ejercicioSimpleRegistro){
        this.ejerciciosRegistro.add(ejercicioSimpleRegistro);
    }

    public void agregarEjercicioAsignacion(EjercicioSimpleAsignacion ejercicioSimpleAsignacion){
        this.ejerciciosAsignaciones.add(ejercicioSimpleAsignacion);
    }

    public void registrarEjercicio(EjercicioSimpleRegistro ejercicioSimpleRegistro){
        this.agregarEjercicioSimpleRegistro(ejercicioSimpleRegistro);
    }

    public void realizarEjercicio(Float peso, Integer series, Integer repeticiones){
        EjercicioSimpleAsignacion ejercicioSimpleAsignacion = this.getEjerciciosAsignaciones().get(ejerciciosAsignaciones.size() - 1);
        Boolean completado = ejercicioSimpleAsignacion.fueCumplida(peso, series, repeticiones);
        EjercicioSimpleRegistro ejercicioSimpleRegistro = new EjercicioSimpleRegistro(peso, series, repeticiones, completado);
        this.registrarEjercicio(ejercicioSimpleRegistro);
    }
}
