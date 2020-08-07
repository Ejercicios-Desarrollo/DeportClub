package domain.rutina.ejercicios;

import domain.rutina.ejercicios.EjercicioSimple;

public class EjercicioSimpleAsignacion {
    private EjercicioSimple ejercicio;
    private Float peso;
    private Integer series;
    private Integer repeticiones;

    public EjercicioSimpleAsignacion(EjercicioSimple ejercicio, Float peso, Integer series, Integer repeticiones){
        this.ejercicio = ejercicio;
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    public EjercicioSimple getEjercicio() {
        return ejercicio;
    }

    public Float getPeso() {
        return peso;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public Boolean fueCumplida(Float peso, Integer Series, Integer repeticiones){
        return this.peso.equals(peso) && this.series.equals(series) && this.repeticiones.equals(repeticiones);
    }
}
