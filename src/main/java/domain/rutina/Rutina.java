package domain.rutina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rutina {
    private List<DiaEntrenamiento> diasEntrenamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Rutina(Integer duracionEnSemanas){
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusWeeks(duracionEnSemanas);
        this.diasEntrenamiento = new ArrayList<>();
    }

    public void agregarDiasEntrenamiento(DiaEntrenamiento ... diasEntrenamiento){
        Collections.addAll(this.diasEntrenamiento, diasEntrenamiento);
    }

    public List<DiaEntrenamiento> getDiasEntrenamiento(){
        return this.diasEntrenamiento;
    }
}
