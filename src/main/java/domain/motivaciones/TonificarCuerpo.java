package domain.motivaciones;

import domain.Deportista;
import domain.Sexo;
import domain.calculos_ideales.AdapterCalculoIdeal;
import domain.calculos_ideales.AdapterCalculoIdealExterno;
import domain.rutina.ejercicios.Ejercicio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@DiscriminatorValue("motivacion_tonificar_cuerpo")
public class TonificarCuerpo extends Motivacion{
    @Column(name = "nivel_grasa_ideal")
    private Float nivelDeGrasaIdeal;

    @Column(name = "nivel_masa_muscualr_ideal")
    private Float nivelDeMasaMuscularIdeal;

    @Transient
    private AdapterCalculoIdeal adapter;

    @Transient
    private static Float minimoNivelAerobico = (float) 0;

    @Transient
    private static Float maximoNivelAerobico = 4f;

    @Transient
    private static Float minimoNivelEjercitacionMuscular = 5f;

    @Transient
    private static Float maximoNivelEjercitacionMuscular = 5f;

    @Transient
    private static Integer cantidadEjerciciosPromedio = 15;

    public TonificarCuerpo(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        super(deportista, diasDisponibles, ejercicios);
        this.adapter = new AdapterCalculoIdealExterno();
        calcularNivelesIdeales(deportista);
    }

    public void calcularNivelesIdeales(Deportista deportista){
        this.nivelDeGrasaIdeal = this.adapter.calcularNivelDeGrasaIdeal(deportista.getAltura(), deportista.getUltimoPeso(),deportista.getSexo());
        this.nivelDeMasaMuscularIdeal = this.adapter.calcularNivelDeMasaMuscularIdeal(deportista.getAltura(), deportista.getUltimoPeso(),deportista.getSexo());
    }

    @Override
    protected void verificiarCumplimientoMotivacion() {
        Float nivelDeGrasaActual = this.deportista.getUltimoNivelDeGrasa();
        Float nivelDeMasaMuscularActual = this.deportista.getUltimoNivelDeMasaMuscular();
        if(nivelDeGrasaActual <= nivelDeGrasaIdeal && nivelDeMasaMuscularActual >= nivelDeMasaMuscularIdeal){
            // Sugerir cambiar a Motivacion de MantenerFigura
        }
    }

    @Override
    protected void cambiarMotivacion(Motivacion motivacion) {
        this.deportista.agregarMotivacion(motivacion);
    }
}
