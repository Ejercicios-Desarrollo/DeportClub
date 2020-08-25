package domain.rutina;

import domain.Persistente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "rutina")
public class Rutina extends Persistente {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rutina_id")
    private List<DiaEntrenamiento> diasEntrenamiento;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public Rutina(){

    }

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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
