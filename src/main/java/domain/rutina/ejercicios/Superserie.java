package domain.rutina.ejercicios;

import java.util.*;

public class Superserie extends Ejercicio {
    private List<EjercicioSimple> ejercicios;

    public Superserie(String descripcion, TipoEjercicio tipoEjercicio, TipoMusculo tipoMusculo) {
        super(descripcion, tipoEjercicio, tipoMusculo);
        this.ejercicios = new ArrayList<>();
    }

    @Override
    public Double getEjercitacionMuscular() {
        DoubleSummaryStatistics summaryStatistics =  this.ejercicios
                .stream()
                .mapToDouble(Ejercicio::getEjercitacionMuscular)
                .summaryStatistics();
        return summaryStatistics.getAverage();
    }

    @Override
    public Double getNivelAerobico() {
        DoubleSummaryStatistics summaryStatistics =  this.ejercicios
                .stream()
                .mapToDouble(Ejercicio::getNivelAerobico)
                .summaryStatistics();
        return summaryStatistics.getAverage();
    }

    public void agregarEjercicios(EjercicioSimple ... ejercicios){
        Collections.addAll(this.ejercicios, ejercicios);
    }

    @Override
    public List<EjercicioSimple> getEjercicios() {
        return ejercicios;
    }
}
