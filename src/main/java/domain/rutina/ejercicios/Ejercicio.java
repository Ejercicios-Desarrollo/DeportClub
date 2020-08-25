package domain.rutina.ejercicios;

import domain.Persistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ejercicio")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Ejercicio extends Persistente {
    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoMusculo musculo;

    @Transient
    protected TipoEjercicio tipoEjercicio;

    public Ejercicio(){

    }

    public Ejercicio(String descripcion, TipoMusculo tipoMusculo){
        this.descripcion = descripcion;
        this.musculo = tipoMusculo;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public TipoMusculo getTipoMusculo(){
        return musculo;
    }

    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    public abstract Double getEjercitacionMuscular();
    public abstract Double getNivelAerobico();
    public abstract List<Ejercicio> getEjercicios();
}
