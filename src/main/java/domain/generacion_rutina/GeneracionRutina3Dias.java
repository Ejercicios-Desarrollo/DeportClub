package domain.generacion_rutina;

import domain.motivaciones.Motivacion;
import domain.rutina.DiaEntrenamiento;
import domain.rutina.ejercicios.Ejercicio;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.EjercicioSimpleAsignacion;
import domain.rutina.ejercicios.TipoMusculo;

import java.time.DayOfWeek;
import java.util.List;

public class GeneracionRutina3Dias extends EstrategiaGeneracionRutina{

    public GeneracionRutina3Dias(List<Ejercicio> ejercicios) {
        super(ejercicios);
    }

    @Override
    public Rutina generarRutina(Motivacion motivacion, List<DayOfWeek> diasDisponibles) {
        Integer cantidadEjerciciosPorMusculo = motivacion.getCantidadEjerciosPromedio() / 3;
        List<Ejercicio> ejerciciosFiltrados = filtrarListaEjerciciosPorNiveles(motivacion);
        List<Ejercicio> ejerciciosPecho = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.PECHO);
        List<Ejercicio> ejerciciosEspalda = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.ESPALDA);
        List<Ejercicio> ejerciciosBrazos = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.BRAZOS);
        List<Ejercicio> ejerciciosHombros = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.HOMBROS);
        List<Ejercicio> ejerciciosPiernas = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.PIERNAS);
        List<Ejercicio> ejerciciosAbdominales = filtrarListaEjerciciosPorMusculo(this.ejercicios, TipoMusculo.ABDOMINALES);

        DiaEntrenamiento diaEntrenamiento1 = new DiaEntrenamiento(diasDisponibles.get(0));
        diaEntrenamiento1.agregarEjercicios(getNEjerciciosRandom(ejerciciosPecho, cantidadEjerciciosPorMusculo));
        diaEntrenamiento1.agregarEjercicios(getNEjerciciosRandom(ejerciciosBrazos, cantidadEjerciciosPorMusculo));
        diaEntrenamiento1.agregarEjercicios(getNEjerciciosRandom(ejerciciosAbdominales, cantidadEjerciciosPorMusculo));
        diaEntrenamiento1.getDiaEntrenamientoEjercicios().forEach(dE -> dE.agregarEjercicioAsignacion(new EjercicioSimpleAsignacion(pesoDefecto, cantidadSeries, cantidadRepeticiones)));

        DiaEntrenamiento diaEntrenamiento2 = new DiaEntrenamiento(diasDisponibles.get(1));
        diaEntrenamiento2.agregarEjercicios(getNEjerciciosRandom(ejerciciosEspalda, cantidadEjerciciosPorMusculo));
        diaEntrenamiento2.agregarEjercicios(getNEjerciciosRandom(ejerciciosBrazos, cantidadEjerciciosPorMusculo));
        diaEntrenamiento2.agregarEjercicios(getNEjerciciosRandom(ejerciciosAbdominales, cantidadEjerciciosPorMusculo));
        diaEntrenamiento2.getDiaEntrenamientoEjercicios().forEach(dE -> dE.agregarEjercicioAsignacion(new EjercicioSimpleAsignacion(pesoDefecto, cantidadSeries, cantidadRepeticiones)));

        DiaEntrenamiento diaEntrenamiento3 = new DiaEntrenamiento(diasDisponibles.get(2));
        diaEntrenamiento3.agregarEjercicios(getNEjerciciosRandom(ejerciciosPiernas, cantidadEjerciciosPorMusculo));
        diaEntrenamiento3.agregarEjercicios(getNEjerciciosRandom(ejerciciosHombros, cantidadEjerciciosPorMusculo));
        diaEntrenamiento3.getDiaEntrenamientoEjercicios().forEach(dE -> dE.agregarEjercicioAsignacion(new EjercicioSimpleAsignacion(pesoDefecto, cantidadSeries, cantidadRepeticiones)));

        Rutina rutina = new Rutina(3);
        rutina.agregarDiasEntrenamiento(diaEntrenamiento1, diaEntrenamiento2, diaEntrenamiento3);

        return rutina;
    }
}
