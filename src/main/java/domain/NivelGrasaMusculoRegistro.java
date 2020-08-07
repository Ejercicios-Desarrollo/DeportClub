package domain;

import java.time.LocalDateTime;

public class NivelGrasaMusculoRegistro {
    private Float nivelDeGrasa;
    private Float nivelDeMasaMuscular;
    private LocalDateTime fechaHora;

    public NivelGrasaMusculoRegistro(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        this.fechaHora = LocalDateTime.now();
        this.nivelDeGrasa = nivelDeGrasa;
        this.nivelDeMasaMuscular = nivelDeMasaMuscular;
    }

    public Float getNivelDeGrasa() {
        return nivelDeGrasa;
    }

    public Float getNivelDeMasaMuscular() {
        return nivelDeMasaMuscular;
    }
}
