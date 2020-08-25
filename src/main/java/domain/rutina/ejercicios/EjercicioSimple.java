package domain.rutina.ejercicios;

import domain.rutina.DiaEntrenamiento;
import domain.rutina.registro.EjercicioSimpleRegistro;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("ejercicio_simple")
public class EjercicioSimple extends Ejercicio {
    @Column(name = "ejercitacion_muscular")
    private Double nivelEjercitacionMuscular;

    @Column(name = "nivel_aerobico")
    private Double nivelAerobico;

    public EjercicioSimple(String descripcion, TipoEjercicio tipoEjercicio, TipoMusculo tipoMusculo,
                           Double nivelEjercitacionMuscular, Double nivelAerobico){
        super(descripcion, tipoMusculo);
        this.tipoEjercicio = TipoEjercicio.SIMPLE;
        this.nivelEjercitacionMuscular = nivelEjercitacionMuscular;
        this.nivelAerobico = nivelAerobico;
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
    public List<Ejercicio> getEjercicios() {
        return null;
    }
}
