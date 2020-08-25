package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "nivel_grasa_musculo_registro")
public class NivelGrasaMusculoRegistro extends Persistente{
    @Column(name = "nivel_grasa")
    private Float nivelDeGrasa;

    @Column(name = "nivel_masa_muscular")
    private Float nivelDeMasaMuscular;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaHora;

    public NivelGrasaMusculoRegistro(){

    }

    public NivelGrasaMusculoRegistro(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        this.nivelDeGrasa = nivelDeGrasa;
        this.nivelDeMasaMuscular = nivelDeMasaMuscular;
        this.fechaHora = LocalDateTime.now();
    }

    public Float getNivelDeGrasa() {
        return nivelDeGrasa;
    }

    public Float getNivelDeMasaMuscular() {
        return nivelDeMasaMuscular;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
