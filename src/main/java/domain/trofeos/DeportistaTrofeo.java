package domain.trofeos;

import domain.Deportista;
import domain.Persistente;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deportista_trofeo")
public class DeportistaTrofeo extends Persistente {
    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

    @ManyToOne
    @JoinColumn(name = "trofeo_id")
    private Trofeo trofeo;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaObtencion;

    public DeportistaTrofeo(){

    }

    public DeportistaTrofeo(Deportista deportista, Trofeo trofeo){
        this.deportista = deportista;
        this.trofeo = trofeo;
        this.fechaObtencion = LocalDate.now();
    }

    public Deportista getDeportista() {
        return deportista;
    }

    public Trofeo getTrofeo() {
        return trofeo;
    }

    public LocalDate getFechaObtencion() {
        return fechaObtencion;
    }
}
