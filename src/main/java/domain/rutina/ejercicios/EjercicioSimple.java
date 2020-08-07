package domain.rutina.ejercicios;

import domain.rutina.DiaEntrenamiento;
import domain.rutina.registro.EjercicioSimpleRegistro;

import java.util.List;
import java.util.stream.Collectors;

public class EjercicioSimple extends Ejercicio {
    private Double nivelEjercitacionMuscular;
    private Double nivelAerobico;


    public EjercicioSimple(String descripcion, TipoEjercicio tipoEjercicio, TipoMusculo tipoMusculo,
                           Double nivelEjercitacionMuscular, Double nivelAerobico){
        super(descripcion, tipoEjercicio, tipoMusculo);
        this.nivelEjercitacionMuscular = nivelEjercitacionMuscular;
        this.nivelAerobico = nivelAerobico;
    }

    public void serRealizado(Float peso, Integer series, Integer repeticiones,
                             DiaEntrenamiento diaEntrenamiento) {
        EjercicioSimpleAsignacion ejercicioSimpleAsignacion = getEjercicioDeLista(diaEntrenamiento);
        Boolean completado = ejercicioSimpleAsignacion.fueCumplida(peso, series, repeticiones);
        EjercicioSimpleRegistro ejercicioSimpleRegistro = new EjercicioSimpleRegistro(this, peso, series, repeticiones, completado);
        diaEntrenamiento.registrarEjercicio(ejercicioSimpleRegistro);
    }

    private EjercicioSimpleAsignacion getEjercicioDeLista(DiaEntrenamiento diaEntrenamiento){
        List<EjercicioSimpleAsignacion> ejerciciosAsignacionesFiltrados = diaEntrenamiento
                .getEjerciciosAsignaciones()
                .stream()
                .filter(eA -> eA.getEjercicio() == this).collect(Collectors.toList());
        return ejerciciosAsignacionesFiltrados.get(0);
    }

    @Override
    public Double getEjercitacionMuscular() {
        return this.nivelEjercitacionMuscular;
    }

    @Override
    public Double getNivelAerobico() {
        return this.nivelAerobico;
    }

    @Override
    public List<EjercicioSimple> getEjercicios() {
        return null;
    }
}
