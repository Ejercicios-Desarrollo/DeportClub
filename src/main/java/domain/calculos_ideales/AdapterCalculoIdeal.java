package domain.calculos_ideales;

import domain.Sexo;

public interface AdapterCalculoIdeal {
    public Float calcularPesoIdeal(Float pesoInicial, Float altura, Sexo sexo);
    public Float calcularNivelDeGrasaIdeal(Float altura, Float peso, Sexo sexo);
    public Float calcularNivelDeMasaMuscularIdeal(Float altura, Float peso, Sexo sexo);
}
