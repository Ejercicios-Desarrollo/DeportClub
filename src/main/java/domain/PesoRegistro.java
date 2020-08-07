package domain;

import java.time.LocalDateTime;

public class PesoRegistro {
    private Float peso;
    private LocalDateTime fechaHora;

    public PesoRegistro(Float peso) {
        this.peso = peso;
        this.fechaHora = LocalDateTime.now();
    }

    public Float getPeso() {
        return peso;
    }
}
