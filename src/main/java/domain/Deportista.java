package domain;

import domain.motivaciones.Motivacion;
import domain.rutina.Rutina;
import domain.trofeos.Trofeo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Deportista {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private Sexo sexo;
    private Float altura;
    private List<Motivacion> motivaciones;
    private List<Rutina> rutinas;
    private List<Trofeo> trofeos;
    private List<PesoRegistro> pesoRegistros;
    private List<NivelGrasaMusculoRegistro> nivelGrasaMusculoRegistros;

    public Deportista(String nombre, String apellido,
                      Sexo sexo, Float altura){
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.altura = altura;
        this.motivaciones = new ArrayList<>();
        this.rutinas = new ArrayList<>();
        this.trofeos = new ArrayList<>();
        this.pesoRegistros = new ArrayList<>();
        this.nivelGrasaMusculoRegistros = new ArrayList<>();
    }

    public void pesarse(Float peso){
        agregarPesoRegistro(peso);
    }

    public void medirNivelesGrasaMusculo(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        agregarNivelGrasaMusculoRegistro(nivelDeGrasa, nivelDeMasaMuscular);
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Float getAltura() {
        return altura;
    }

    public void agregarRutina(Rutina rutina){
        this.rutinas.add(rutina);
    }

    public Float getUltimoPeso() {
        PesoRegistro ultimoPesoRegistro = this.pesoRegistros.get(pesoRegistros.size() - 1);
        return ultimoPesoRegistro.getPeso();
    }

    public Rutina getUltimaRutina() {
        Rutina ultimaRutina = this.rutinas.get(rutinas.size() - 1);
        return ultimaRutina;
    }

    public Float getUltimoNivelDeGrasa() {
        NivelGrasaMusculoRegistro ultimoNivelGrasaMusculoRegistro = this.nivelGrasaMusculoRegistros.get(nivelGrasaMusculoRegistros.size() - 1);
        return ultimoNivelGrasaMusculoRegistro.getNivelDeGrasa();
    }

    public Float getUltimoNivelDeMasaMuscular() {
        NivelGrasaMusculoRegistro ultimoNivelGrasaMusculoRegistro = this.nivelGrasaMusculoRegistros.get(nivelGrasaMusculoRegistros.size() - 1);
        return ultimoNivelGrasaMusculoRegistro.getNivelDeMasaMuscular();
    }

    public Motivacion getUltimaMotivacion() {
        Motivacion motivacion = this.motivaciones.get(motivaciones.size() - 1);
        return motivacion;
    }

    public void agregarNivelGrasaMusculoRegistro(Float nivelDeGrasa, Float nivelDeMasaMuscular){
        this.nivelGrasaMusculoRegistros.add(new NivelGrasaMusculoRegistro(nivelDeGrasa, nivelDeMasaMuscular));
    }

    public void agregarPesoRegistro(Float peso){
        this.pesoRegistros.add(new PesoRegistro(peso));
    }

    public void agregarMotivacion(Motivacion motivacion){
        this.motivaciones.add(motivacion);
    }

    public void agregarTrofeo(Trofeo trofeo){
        this.trofeos.add(trofeo);
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }
}
