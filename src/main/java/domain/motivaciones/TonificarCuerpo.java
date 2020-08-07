package domain.motivaciones;

import domain.Deportista;
import domain.Sexo;
import domain.calculos_ideales.AdapterCalculoIdeal;
import domain.calculos_ideales.AdapterCalculoIdealExterno;
import domain.rutina.ejercicios.Ejercicio;

import java.time.DayOfWeek;
import java.util.List;

public class TonificarCuerpo extends Motivacion{
    private Float nivelDeGrasaIdeal;
    private Float nivelDeMasaMuscularIdeal;
    private AdapterCalculoIdeal adapter;
    private static Float minimoNivelAerobico = (float) 0;
    private static Float maximoNivelAerobico = 4f;
    private static Float minimoNivelEjercitacionMuscular = 5f;
    private static Float maximoNivelEjercitacionMuscular = 5f;
    private static Integer cantidadEjerciciosPromedio = 15;

    public TonificarCuerpo(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        super(deportista, diasDisponibles, ejercicios);
        this.adapter = new AdapterCalculoIdealExterno();
        calcularNivelesIdeales(deportista);
    }

    public void calcularNivelesIdeales(Deportista deportista){
        calcularNivelDeGrasaIdeal(deportista.getAltura(), deportista.getUltimoPeso(),deportista.getSexo());
        calcularNivelDeMasaMuscularIdeal(deportista.getAltura(), deportista.getUltimoPeso(),deportista.getSexo());
    }

    public void calcularNivelDeGrasaIdeal(Float altura, Float peso, Sexo sexo){
        this.nivelDeGrasaIdeal = this.adapter.calcularNivelDeGrasaIdeal(altura, peso, sexo);
    }

    public void calcularNivelDeMasaMuscularIdeal(Float altura, Float peso, Sexo sexo){
        this.nivelDeMasaMuscularIdeal = this.adapter.calcularNivelDeMasaMuscularIdeal(altura, peso, sexo);
    }

    @Override
    protected void verificiarCumplimientoMotivacion() {
        Float nivelDeGrasaActual = this.deportista.getUltimoNivelDeGrasa();
        Float nivelDeMasaMuscularActual = this.deportista.getUltimoNivelDeMasaMuscular();
        if(nivelDeGrasaActual <= nivelDeGrasaIdeal && nivelDeMasaMuscularActual >= nivelDeMasaMuscularIdeal){
            // Sugerir cambiar a Motivacion de MantenerFigura
        }
    }

    @Override
    protected void cambiarMotivacion(Motivacion motivacion) {
        this.deportista.agregarMotivacion(motivacion);
    }
}
