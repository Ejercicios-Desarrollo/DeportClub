package domain.motivaciones;

import domain.Deportista;
import domain.Persistente;
import domain.generacion_rutina.*;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.Ejercicio;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "motivacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Motivacion extends Persistente {
    @Column(columnDefinition = "DATE")
    protected LocalDate fechaFin;

    @Column(columnDefinition = "DATE")
    protected LocalDate fechaInicio;

    @OneToOne
    @JoinColumn(name = "deportista_id")
    protected Deportista deportista;

    @Transient
    protected EstrategiaGeneracionRutina estrategiaGeneracionRutina;

    @Transient
    protected List<DayOfWeek> diasDisponibles;

    @Transient
    protected Double minimoNivelAerobico;

    @Transient
    protected Double maximoNivelAerobico;

    @Transient
    protected Double minimoNivelEjercitacionMuscular;

    @Transient
    protected Double maximoNivelEjercitacionMuscular;

    @Transient
    protected Integer cantidadEjerciciosPromedio = 12;

    @Transient
    protected List<Ejercicio> ejercicios;

    public Motivacion(){
        this.diasDisponibles = new ArrayList<>();
        this.ejercicios = new ArrayList<>();
    }

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
