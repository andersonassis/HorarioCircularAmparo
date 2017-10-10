package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

import android.support.annotation.NonNull;

/**
 * Created by AndersonLuis on 29/09/2017.
 */

public class HorariosModel  {

    private int id;
    private String descricao;
    private String hora;
    private String saida;

    public HorariosModel(){

    }

    public HorariosModel(String descricao, String hora, String saida,int id) {
        this.descricao = descricao;
        this.hora      = hora;
        this.saida     = saida;
        this.id        = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "HorariosModel{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", hora='" + hora + '\'' +
                ", saida='" + saida + '\'' +
                '}';
    }
}
