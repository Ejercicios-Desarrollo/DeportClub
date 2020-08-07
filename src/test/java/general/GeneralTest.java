package general;

import domain.Deportista;
import domain.Sexo;
import domain.generacion_rutina.EstrategiaGeneracionRutina;
import domain.generacion_rutina.GeneracionRutina3Dias;
import domain.motivaciones.BajarDePeso;
import domain.motivaciones.Motivacion;
import domain.rutina.Rutina;
import domain.rutina.ejercicios.Ejercicio;
import domain.rutina.ejercicios.EjercicioSimple;
import domain.rutina.ejercicios.TipoEjercicio;
import domain.rutina.ejercicios.TipoMusculo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneralTest {
    Deportista deportista;
    Ejercicio ejercicioCorrer;
    Ejercicio ejercicioSaltar;
    Ejercicio ejercicioPecho1;
    Ejercicio ejercicioPecho2;
    Ejercicio ejercicioPecho3;
    Ejercicio ejercicioPecho4;
    Ejercicio ejercicioEspalda1;
    Ejercicio ejercicioEspalda2;
    Ejercicio ejercicioEspalda3;
    Ejercicio ejercicioEspalda4;
    Ejercicio ejercicioBrazos1;
    Ejercicio ejercicioBrazos2;
    Ejercicio ejercicioBrazos3;
    Ejercicio ejercicioBrazos4;
    Ejercicio ejercicioBrazos5;
    Ejercicio ejercicioBrazos6;
    Ejercicio ejercicioHombros1;
    Ejercicio ejercicioHombros2;
    Ejercicio ejercicioHombros3;
    Ejercicio ejercicioHombros4;
    Ejercicio ejercicioPiernas1;
    Ejercicio ejercicioPiernas2;
    Ejercicio ejercicioPiernas3;
    Ejercicio ejercicioPiernas4;
    List<Ejercicio> ejerciciosLista;
    List<Ejercicio> ejercicios;


    @Before
    public void init(){

        this.ejercicioCorrer = new EjercicioSimple("Correr en cinta", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 5d, 7d);
        this.ejercicioSaltar = new EjercicioSimple("Saltar la soga", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 5d, 10d);
        this.ejercicioPecho1 = new EjercicioSimple("Press plano", TipoEjercicio.SIMPLE,
                TipoMusculo.PECHO, 8d, 2d);
        this.ejercicioPecho2 = new EjercicioSimple("Press inclinado", TipoEjercicio.SIMPLE,
                TipoMusculo.PECHO, 8d, 2d);
        this.ejercicioPecho3 = new EjercicioSimple("Press declinado", TipoEjercicio.SIMPLE,
                TipoMusculo.PECHO, 8d, 2d);
        this.ejercicioPecho4 = new EjercicioSimple("Flexiones", TipoEjercicio.SIMPLE,
                TipoMusculo.PECHO, 6d, 4d);
        this.ejercicioEspalda1 = new EjercicioSimple("Dominadas", TipoEjercicio.SIMPLE,
                TipoMusculo.ESPALDA, 8d, 2d);
        this.ejercicioEspalda2 = new EjercicioSimple("Remo barra", TipoEjercicio.SIMPLE,
                TipoMusculo.ESPALDA, 8d, 2d);
        this.ejercicioEspalda3 = new EjercicioSimple("Remo mancuernas", TipoEjercicio.SIMPLE,
                TipoMusculo.ESPALDA, 8d, 2d);
        this.ejercicioEspalda4 = new EjercicioSimple("Dorsales", TipoEjercicio.SIMPLE,
                TipoMusculo.ESPALDA, 8d, 2d);
        this.ejercicioBrazos1 = new EjercicioSimple("Biceps alternado", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioBrazos2 = new EjercicioSimple("Biceps concentrado", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioBrazos3 = new EjercicioSimple("Biceps barra EZ", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioBrazos4 = new EjercicioSimple("Triceps banco", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioBrazos5 = new EjercicioSimple("Triceps frances", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioBrazos6 = new EjercicioSimple("Triceps romano", TipoEjercicio.SIMPLE,
                TipoMusculo.BRAZOS, 7d, 2d);
        this.ejercicioHombros1 = new EjercicioSimple("Press militar", TipoEjercicio.SIMPLE,
                TipoMusculo.HOMBROS, 7d, 2d);
        this.ejercicioHombros2 = new EjercicioSimple("Vuelos laterales", TipoEjercicio.SIMPLE,
                TipoMusculo.HOMBROS, 7d, 2d);
        this.ejercicioHombros3 = new EjercicioSimple("Vuelos frontales", TipoEjercicio.SIMPLE,
                TipoMusculo.HOMBROS, 7d, 2d);
        this.ejercicioHombros4 = new EjercicioSimple("Trapecio", TipoEjercicio.SIMPLE,
                TipoMusculo.HOMBROS, 7d, 2d);
        this.ejercicioPiernas1 = new EjercicioSimple("Sentadilla", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 10d, 2d);
        this.ejercicioPiernas2 = new EjercicioSimple("Peso muerto", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 10d, 2d);
        this.ejercicioPiernas3 = new EjercicioSimple("Estocadas", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 8d, 2d);
        this.ejercicioPiernas4 = new EjercicioSimple("Gemelos", TipoEjercicio.SIMPLE,
                TipoMusculo.PIERNAS, 7d, 2d);

        this.ejerciciosLista = Arrays.asList(ejercicioCorrer, ejercicioSaltar,
                ejercicioBrazos1, ejercicioBrazos2, ejercicioBrazos3, ejercicioBrazos4,
                ejercicioEspalda1, ejercicioEspalda2, ejercicioEspalda3, ejercicioEspalda4,
                ejercicioPecho1, ejercicioPecho2, ejercicioPecho3, ejercicioPecho4,
                ejercicioHombros1, ejercicioHombros2, ejercicioHombros3, ejercicioHombros4,
                ejercicioPiernas1, ejercicioPiernas2, ejercicioPiernas3, ejercicioPiernas4);

        this.ejercicios = new ArrayList<>();
        ejercicios.addAll(ejerciciosLista);

        this.deportista = new Deportista("Juan", "Perez", Sexo.MASCULINO, 1.70f);
        this.deportista.pesarse(80f);
        this.deportista.medirNivelesGrasaMusculo(20f, 70f);
        List<DayOfWeek> diasDisponibles = new ArrayList<>();
        Collections.addAll(diasDisponibles, DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
        Motivacion motivacion = new BajarDePeso(deportista, diasDisponibles, ejercicios);
        this.deportista.agregarMotivacion(motivacion);
    }

    @Test
    public void verificar(){
        Motivacion motivacion = this.deportista.getUltimaMotivacion();
        motivacion.generarRutina();
        Rutina rutina = this.deportista.getUltimaRutina();
        Assert.assertEquals(java.util.Optional.of(80f), java.util.Optional.of(deportista.getUltimoPeso()));
        Assert.assertEquals(java.util.Optional.of(75f), java.util.Optional.of(motivacion.getPesoIdeal()));
        Assert.assertEquals(3, motivacion.getDiasDisponibles().size());
        Assert.assertEquals(44, motivacion.getEjercicios().size());
        Assert.assertEquals(3, rutina.getDiasEntrenamiento().size());
    }

}
