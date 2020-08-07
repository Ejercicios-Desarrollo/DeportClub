package domain.rutina.ejercicios;

import java.util.List;

public abstract class Ejercicio {
    private String descripcion;
    private TipoEjercicio tipoEjercicio;
    private TipoMusculo tipoMusculo;

    public Ejercicio(String descripcion, TipoEjercicio tipoEjercicio, TipoMusculo tipoMusculo){
        this.descripcion = descripcion;
        this.tipoEjercicio = tipoEjercicio;
        this.tipoMusculo = tipoMusculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    public TipoMusculo getTipoMusculo(){
        return tipoMusculo;
    }

    public abstract Double getEjercitacionMuscular();
    public abstract Double getNivelAerobico();
    public abstract List<EjercicioSimple> getEjercicios();
}
