package domain.rutina.registro;

import domain.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "dia_entrenamiento_registro")
public class DiaEntrenamientoRegistro extends Persistente {
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaHoraInicio;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaHoraFin;

    public DiaEntrenamientoRegistro(){

    }

    public DiaEntrenamientoRegistro(LocalDateTime fechaHoraInicio){
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
}
