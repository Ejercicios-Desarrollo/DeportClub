package domain.motivaciones;

import domain.Deportista;
import domain.rutina.ejercicios.Ejercicio;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class MantenerFigura extends Motivacion{
    private static Integer nUnidadesPeso;
    private static Float minimoNivelAerobico = 2f;
    private static Float maximoNivelAerobico = 4f;
    private static Float minimoNivelEjercitacionMuscular = 1f;
    private static Float maximoNivelEjercitacionMuscular = 3f;
    private static Integer cantidadEjerciciosPromedio = 8;

    public MantenerFigura(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        super(deportista, diasDisponibles, ejercicios);
    }

    @Override
    protected void verificiarCumplimientoMotivacion() {
        Float pesoActual = this.deportista.getUltimoPeso();
        if(pesoActual < pesoActual - nUnidadesPeso || pesoActual > pesoActual + nUnidadesPeso){
            // Sugerir o cambiar a otra motivacion
        }
    }

    @Override
    protected void cambiarMotivacion(Motivacion motivacion) {
        this.deportista.agregarMotivacion(motivacion);
    }
}
