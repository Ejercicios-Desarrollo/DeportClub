package domain.rutina;

import domain.Persistente;
import domain.converters.DiaDeLaSemanaConverter;
import domain.rutina.ejercicios.Ejercicio;
import domain.rutina.ejercicios.EjercicioSimple;
import domain.rutina.ejercicios.EjercicioSimpleAsignacion;
import domain.rutina.registro.DiaEntrenamientoRegistro;
import domain.rutina.registro.EjercicioSimpleRegistro;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "dia_entrenamiento")
public class DiaEntrenamiento extends Persistente {
    @Convert(converter = DiaDeLaSemanaConverter.class)
    private DayOfWeek dayOfWeek;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dia_entrenamiento_id")
    private List<DiaEntrenamientoRegistro> diasEntrenamientoRegistro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "diaEntrenamiento")
    private List<DiaEntrenamientoEjercicio> diaEntrenamientoEjercicios;

    public DiaEntrenamiento(){
        this.diasEntrenamientoRegistro = new ArrayList<>();
        this.diaEntrenamientoEjercicios = new ArrayList<>();
    }

    public DiaEntrenamiento(DayOfWeek dayOfWeek){
        this.dayOfWeek = dayOfWeek;
        this.diasEntrenamientoRegistro = new ArrayList<>();
        this.diaEntrenamientoEjercicios = new ArrayList<>();
    }

    public void agregarEjercicios(List<Ejercicio> ejercicios){
        ejercicios.forEach(ejercicio -> this.diaEntrenamientoEjercicios.add(new DiaEntrenamientoEjercicio(this, ejercicio)));
    }

    public void registrarIngreso(){
        this.diasEntrenamientoRegistro.add(new DiaEntrenamientoRegistro(LocalDateTime.now()));
    }

    public void registrarSalida(){
        DiaEntrenamientoRegistro diaEntrenamientoHoy = this.diasEntrenamientoRegistro.get(diasEntrenamientoRegistro.size() - 1);
        diaEntrenamientoHoy.setFechaHoraFin(LocalDateTime.now());
    }

    public List<Ejercicio> getEjercicios() {
        return this.diaEntrenamientoEjercicios.stream().map(DiaEntrenamientoEjercicio::getEjercicio).collect(Collectors.toList());
    }

    public List<DiaEntrenamientoEjercicio> getDiaEntrenamientoEjercicios() {
        return diaEntrenamientoEjercicios;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public List<DiaEntrenamientoRegistro> getDiasEntrenamientoRegistro() {
        return diasEntrenamientoRegistro;
    }
}
