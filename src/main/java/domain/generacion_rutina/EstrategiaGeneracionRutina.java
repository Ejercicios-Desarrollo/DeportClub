package domain.generacion_rutina;

import domain.motivaciones.Motivacion;
import domain.rutina.*;
import domain.rutina.ejercicios.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EstrategiaGeneracionRutina {
    protected List<Ejercicio> ejercicios;
    protected static int cantidadMinimaSemanas = 3;
    protected static int cantidadMaximaSemanas = 4;
    protected static Integer cantidadSeries = 3;
    protected static Integer cantidadRepeticiones = 15;
    protected static Float pesoDefecto = 5f;

    public EstrategiaGeneracionRutina(List<Ejercicio> ejercicios){
        this.ejercicios = new ArrayList<>();
        this.ejercicios.addAll(ejercicios);
    }


    public abstract Rutina generarRutina(Motivacion motivacion, List<DayOfWeek> diasDisponibles);

    protected List<Ejercicio> filtrarListaEjerciciosPorNiveles(Motivacion motivacion){
        List<Ejercicio> ejerciciosFiltrados = this.ejercicios
                .stream()
                .filter(e -> e.getEjercitacionMuscular() >= motivacion.getMinimoNivelEjercitacionMuscular()
                        && e.getEjercitacionMuscular() <= motivacion.getMaximoNivelEjercitacionMuscular()
                        && e.getNivelAerobico() >= motivacion.getMinimoNivelAerobico()
                        && e.getNivelAerobico() <= motivacion.getMaximoNivelAerobico())
                .collect(Collectors.toList());
        return ejerciciosFiltrados;
    }

    protected List<Ejercicio> filtrarListaEjerciciosPorMusculo(List<Ejercicio> ejercicios, TipoMusculo tipoMusculo){
        List<Ejercicio> ejerciciosFiltrados = ejercicios
                .stream()
                .filter(e -> e.getTipoMusculo() == tipoMusculo)
                .collect(Collectors.toList());
        return ejerciciosFiltrados;
    }

    protected List<Ejercicio> getNEjerciciosRandom(List<Ejercicio> ejercicios, Integer cantidad){
        Collections.shuffle(ejercicios);
        return ejercicios.subList(0, cantidad-1);
    }

    protected Integer cantidadSemanas(){
        return (int) (Math.random() * (cantidadMaximaSemanas - cantidadMinimaSemanas + 1) + cantidadMinimaSemanas);
    }

    protected List<EjercicioSimpleAsignacion> asignarSeriesRepeticiones(List<Ejercicio> ejercicios){
        List<EjercicioSimpleAsignacion> ejercicioSimpleAsignaciones = new ArrayList<>();

        List<Ejercicio> ejerciciosSimples = ejercicios.stream().filter(e -> e.getTipoEjercicio() == TipoEjercicio.SIMPLE).collect(Collectors.toList());

        ejerciciosSimples.forEach(eS -> ejercicioSimpleAsignaciones
                .add(new EjercicioSimpleAsignacion((EjercicioSimple) eS, pesoDefecto, cantidadSeries, cantidadRepeticiones)));

        List<Ejercicio> superseries = ejercicios.stream().filter(e -> e.getTipoEjercicio() == TipoEjercicio.SUPERSERIE).collect(Collectors.toList());

        List<EjercicioSimple> ejercicioSimplesDeSuperseries = new ArrayList<>();

        superseries.forEach(s -> ejercicioSimplesDeSuperseries.addAll(s.getEjercicios()));

        ejercicioSimplesDeSuperseries.forEach(eS -> ejercicioSimpleAsignaciones
                .add(new EjercicioSimpleAsignacion((EjercicioSimple) eS, pesoDefecto, cantidadSeries, cantidadRepeticiones)));

        return ejercicioSimpleAsignaciones;
    }
}
