package domain;

import java.time.LocalDateTime;

public class NivelGrasaMusculoRegistro {
    private Float nivelDeGrasa;
    private Float nivelDeMasaMuscular;
    private LocalDateTime fechaHora;

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
}
