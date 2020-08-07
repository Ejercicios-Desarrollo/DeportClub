package domain.rutina.registro;

import domain.rutina.ejercicios.EjercicioSimple;

import java.time.LocalDateTime;

public class EjercicioSimpleRegistro {
    private EjercicioSimple ejercicio;
    private Float peso;
    private Integer series;
    private Integer repeticiones;
    private LocalDateTime fechaHora;
    private Boolean completado;

    public EjercicioSimpleRegistro(EjercicioSimple ejercicio, Float peso, Integer series, Integer repeticiones,
                                   Boolean completado){
        this.ejercicio = ejercicio;
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
        this.completado = completado;
    }
}
