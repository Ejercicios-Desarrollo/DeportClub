package domain.motivaciones;

import domain.Deportista;
import domain.generacion_rutina.*;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.Ejercicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Motivacion {
    protected LocalDate fechaFin;
    protected LocalDate fechaInicio;
    protected Deportista deportista;
    protected EstrategiaGeneracionRutina estrategiaGeneracionRutina;
    protected List<DayOfWeek> diasDisponibles;
    protected Double minimoNivelAerobico;
    protected Double maximoNivelAerobico;
    protected Double minimoNivelEjercitacionMuscular;
    protected Double maximoNivelEjercitacionMuscular;
    protected Integer cantidadEjerciciosPromedio = 12;
    protected List<Ejercicio> ejercicios;

    public Motivacion(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        this.deportista = deportista;
        this.estrategiaGeneracionRutina = null;
        this.diasDisponibles = new ArrayList<>();
        this.ejercicios = new ArrayList<>();
        this.diasDisponibles.addAll(diasDisponibles);
        this.ejercicios.addAll(ejercicios);
    }

    protected abstract void verificiarCumplimientoMotivacion();
    protected abstract void cambiarMotivacion(Motivacion motivacion);

    private void asignarEstrategiaGeneracionRutina(){
        int cantidadDias = diasDisponibles.size();
        System.out.println("cantidadDias: " + cantidadDias);
        switch(cantidadDias){
            case 3:
                this.estrategiaGeneracionRutina = new GeneracionRutina3Dias(this.ejercicios);
                break;
            case 4:
                this.estrategiaGeneracionRutina = new GeneracionRutina4Dias(this.ejercicios);
                break;
            case 5:
                this.estrategiaGeneracionRutina = new GeneracionRutina5Dias(this.ejercicios);
                break;
            case 6:
                this.estrategiaGeneracionRutina = new GeneracionRutina6Dias(this.ejercicios);
                break;
        }
    }

    public List<Ejercicio> getEjercicios() {
        return this.ejercicios;
    }

    public void generarRutina(){
        asignarEstrategiaGeneracionRutina();
        Rutina rutina = this.estrategiaGeneracionRutina.generarRutina(this, this.diasDisponibles);
        this.deportista.agregarRutina(rutina);
    }

    public Double getMinimoNivelAerobico() {
        return minimoNivelAerobico;
    }

    public Double getMaximoNivelAerobico() {
        return maximoNivelAerobico;
    }

    public Double getMinimoNivelEjercitacionMuscular() {
        return minimoNivelEjercitacionMuscular;
    }

    public Double getMaximoNivelEjercitacionMuscular() {
        return maximoNivelEjercitacionMuscular;
    }

    public Integer getCantidadEjerciosPromedio(){
        return this.cantidadEjerciciosPromedio;
    }

    public List<DayOfWeek> getDiasDisponibles() {
        return diasDisponibles;
    }

    public Float getPesoIdeal(){
        return null;
    }
}
