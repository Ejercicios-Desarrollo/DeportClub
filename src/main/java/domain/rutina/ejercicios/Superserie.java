package domain.rutina.ejercicios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
@DiscriminatorValue("superserie")
public class Superserie extends Ejercicio {
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Ejercicio> ejercicios;

    public Superserie(String descripcion, TipoEjercicio tipoEjercicio, TipoMusculo tipoMusculo) {
        super(descripcion, tipoMusculo);
        this.tipoEjercicio = TipoEjercicio.SUPERSERIE;
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

    public void agregarEjercicios(Ejercicio ... ejercicios){
        Collections.addAll(this.ejercicios, ejercicios);
    }

    @Override
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}
