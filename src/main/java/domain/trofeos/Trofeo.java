package domain.trofeos;

import java.time.LocalDate;

public class Trofeo {
    private String descripcion;
    private LocalDate fechaObtencion;

    public Trofeo(String descripcion){
        this.descripcion = descripcion;
        this.fechaObtencion = LocalDate.now();
    }
}
