package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "peso_registro")
public class PesoRegistro extends Persistente{
    @Column(name = "peso")
    private Float peso;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaHora;

    public PesoRegistro(){

    }

    public PesoRegistro(Float peso) {
        this.peso = peso;
        this.fechaHora = LocalDateTime.now();
    }

    public Float getPeso() {
        return peso;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
