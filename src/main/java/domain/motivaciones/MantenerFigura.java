package domain.motivaciones;

import domain.Deportista;
import domain.rutina.ejercicios.Ejercicio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@DiscriminatorValue("motivacion_mantener_figura")
public class MantenerFigura extends Motivacion{

    @Column(name = "peso_inicial")
    private Float pesoInicial;

    @Transient
    private static Integer nUnidadesPeso;

    @Transient
    private static Float minimoNivelAerobico = 2f;

    @Transient
    private static Float maximoNivelAerobico = 4f;

    @Transient
    private static Float minimoNivelEjercitacionMuscular = 1f;

    @Transient
    private static Float maximoNivelEjercitacionMuscular = 3f;

    @Transient
    private static Integer cantidadEjerciciosPromedio = 8;

    public MantenerFigura(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        super(deportista, diasDisponibles, ejercicios);
        this.pesoInicial = deportista.getUltimoPeso();
    }

    @Override
    protected void verificiarCumplimientoMotivacion() {
        Float pesoActual = this.deportista.getUltimoPeso();
        if(pesoActual < pesoInicial - nUnidadesPeso || pesoActual > pesoInicial + nUnidadesPeso){
            // Sugerir o cambiar a otra motivacion
        }
    }

    @Override
    protected void cambiarMotivacion(Motivacion motivacion) {
        this.deportista.agregarMotivacion(motivacion);
    }
}
