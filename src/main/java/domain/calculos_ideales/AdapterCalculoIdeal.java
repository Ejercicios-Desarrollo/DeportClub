package domain.calculos_ideales;

import domain.Sexo;

public interface AdapterCalculoIdeal {
    Float calcularPesoIdeal(Float pesoInicial, Float altura, Sexo sexo);
    Float calcularNivelDeGrasaIdeal(Float altura, Float peso, Sexo sexo);
    Float calcularNivelDeMasaMuscularIdeal(Float altura, Float peso, Sexo sexo);
}
