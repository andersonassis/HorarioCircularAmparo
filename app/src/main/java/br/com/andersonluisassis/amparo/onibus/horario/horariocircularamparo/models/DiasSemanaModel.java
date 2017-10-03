package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

/**
 * Created by AndersonLuis on 27/09/2017.
 */

public class DiasSemanaModel {
    private String descricao;
    private int id;

    public DiasSemanaModel(){
    }

    public DiasSemanaModel(String descricao) {
        this.descricao    = descricao;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
