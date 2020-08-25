package domain.rutina.ejercicios;

import domain.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ejercicio_simple_asignacion")
public class EjercicioSimpleAsignacion extends Persistente {
    @Column(name = "peso")
    private Float peso;

    @Column(name = "series")
    private Integer series;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    public EjercicioSimpleAsignacion(){

    }

    public EjercicioSimpleAsignacion(Float peso, Integer series, Integer repeticiones){
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
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

    public Boolean fueCumplida(Float peso, Integer series, Integer repeticiones){
        return this.peso.equals(peso) && this.series.equals(series) && this.repeticiones.equals(repeticiones);
    }
}
