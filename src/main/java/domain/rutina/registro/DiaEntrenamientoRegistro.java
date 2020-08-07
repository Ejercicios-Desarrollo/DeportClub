package domain.rutina.registro;

import java.time.LocalDateTime;

public class DiaEntrenamientoRegistro {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    public DiaEntrenamientoRegistro(LocalDateTime fechaHoraInicio){
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
}
