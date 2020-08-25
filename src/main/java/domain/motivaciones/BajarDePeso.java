package domain.motivaciones;

import domain.Deportista;
import domain.Sexo;
import domain.calculos_ideales.AdapterCalculoIdeal;
import domain.calculos_ideales.AdapterCalculoIdealExterno;
import domain.rutina.ejercicios.Ejercicio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@DiscriminatorValue("motivacion_bajar_peso")
public class BajarDePeso extends Motivacion{
    @Column(name = "peso_ideal")
    private Float pesoIdeal;

    @Transient
    private AdapterCalculoIdeal adapter;

    public BajarDePeso(Deportista deportista, List<DayOfWeek> diasDisponibles, List<Ejercicio> ejercicios){
        super(deportista, diasDisponibles, ejercicios);
        this.minimoNivelAerobico = 1d;
        this.maximoNivelAerobico = 10d;
        this.minimoNivelEjercitacionMuscular = 1d;
        this.maximoNivelEjercitacionMuscular = 10d;
        this.cantidadEjerciciosPromedio = 12;
        this.adapter = new AdapterCalculoIdealExterno();
        calcularPesoIdeal(deportista.getUltimoPeso(), deportista.getAltura(), deportista.getSexo());
    }

    public void calcularPesoIdeal(Float pesoInicial, Float altura, Sexo sexo){
        this.pesoIdeal = this.adapter.calcularPesoIdeal(pesoInicial, altura, sexo);
    }

    @Override
    protected void verificiarCumplimientoMotivacion() {
        Float pesoActual = this.deportista.getUltimoPeso();
        if(pesoActual <= pesoIdeal){
            this.cambiarMotivacion(new MantenerFigura(this.deportista, this.diasDisponibles, this.ejercicios));
        }
    }

    @Override
    protected void cambiarMotivacion(Motivacion motivacion) {
        this.deportista.agregarMotivacion(motivacion);
    }

    @Override
    public Float getPesoIdeal() {
        return pesoIdeal;
    }
}
