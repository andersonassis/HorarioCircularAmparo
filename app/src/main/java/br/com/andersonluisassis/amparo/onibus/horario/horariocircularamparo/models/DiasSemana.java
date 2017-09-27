package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

/**
 * Created by AndersonLuis on 27/09/2017.
 */

public class DiasSemana  {
    private String dias;

    public DiasSemana(){
    }


    public DiasSemana(String dias) {
        this.dias = dias;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}
