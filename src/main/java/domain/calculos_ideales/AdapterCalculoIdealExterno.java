package domain.calculos_ideales;

import domain.Sexo;

public class AdapterCalculoIdealExterno implements AdapterCalculoIdeal{
    @Override
    public Float calcularPesoIdeal(Float pesoInicial, Float altura, Sexo sexo) {
        return pesoInicial - 5;
    }

    @Override
    public Float calcularNivelDeGrasaIdeal(Float altura, Float peso, Sexo sexo) {
        if(sexo == Sexo.FEMENINO){
            return 19f;
        }
        else {
            return 13f;
        }
    }

    @Override
    public Float calcularNivelDeMasaMuscularIdeal(Float altura, Float peso, Sexo sexo) {
        if(sexo == Sexo.FEMENINO){
            return 81f;
        }
        else {
            return 84f;
        }
    }
}
