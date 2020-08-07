package domain.generacion_rutina;

import domain.motivaciones.Motivacion;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.Ejercicio;

import java.time.DayOfWeek;
import java.util.List;

public class GeneracionRutina4Dias extends EstrategiaGeneracionRutina{
    public GeneracionRutina4Dias(List<Ejercicio> ejercicios) {
        super(ejercicios);
    }

    @Override
    public Rutina generarRutina(Motivacion motivacion, List<DayOfWeek> diasDisponibles) {
        return null;
    }
}
