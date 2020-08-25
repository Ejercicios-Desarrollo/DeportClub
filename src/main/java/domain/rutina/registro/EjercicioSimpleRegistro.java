package domain.rutina.registro;

import domain.Persistente;
import domain.rutina.ejercicios.EjercicioSimple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ejercicio_simple_registro")
public class EjercicioSimpleRegistro extends Persistente {
    @Column(name = "peso")
    private Float peso;

    @Column(name = "series")
    private Integer series;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaHora;

    @Column(name = "completado")
    private Boolean completado;

    public EjercicioSimpleRegistro(){

    }

    public EjercicioSimpleRegistro(Float peso, Integer series, Integer repeticiones, Boolean completado){
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
        this.completado = completado;
    }
}
