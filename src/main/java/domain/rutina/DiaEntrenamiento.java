package domain.rutina;

import domain.rutina.ejercicios.Ejercicio;
import domain.rutina.ejercicios.EjercicioSimpleAsignacion;
import domain.rutina.registro.DiaEntrenamientoRegistro;
import domain.rutina.registro.EjercicioSimpleRegistro;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaEntrenamiento {
    private DayOfWeek dayOfWeek;
    private List<DiaEntrenamientoRegistro> diasEntrenamientoRegistro;
    private List<Ejercicio> ejercicios;
    private List<EjercicioSimpleAsignacion> ejerciciosAsignaciones;
    private List<EjercicioSimpleRegistro> ejerciciosRegistro;

    public DiaEntrenamiento(DayOfWeek dayOfWeek){
        this.dayOfWeek = dayOfWeek;
        this.diasEntrenamientoRegistro = new ArrayList<>();
        this.ejercicios = new ArrayList<>();
        this.ejerciciosAsignaciones = new ArrayList<>();
        this.ejerciciosRegistro = new ArrayList<>();
    }

    public List<EjercicioSimpleAsignacion> getEjerciciosAsignaciones() {
        return ejerciciosAsignaciones;
    }

    public void agregarEjercicios(List<Ejercicio> ejercicios){
        this.ejercicios.addAll(ejercicios);
    }

    public void registrarIngreso(){
        this.diasEntrenamientoRegistro.add(new DiaEntrenamientoRegistro(LocalDateTime.now()));
    }

    public void registrarSalida(){
        DiaEntrenamientoRegistro diaEntrenamientoHoy = this.diasEntrenamientoRegistro.get(diasEntrenamientoRegistro.size() - 1);
        diaEntrenamientoHoy.setFechaHoraFin(LocalDateTime.now());
    }

    public void registrarEjercicio(EjercicioSimpleRegistro ejercicioSimpleRegistro){
        this.ejerciciosRegistro.add(ejercicioSimpleRegistro);
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void agregarEjerciciosAsignaciones(List<EjercicioSimpleAsignacion> ejercicioSimpleAsignacioness){
        this.ejerciciosAsignaciones.addAll(ejercicioSimpleAsignacioness);
    }
}
