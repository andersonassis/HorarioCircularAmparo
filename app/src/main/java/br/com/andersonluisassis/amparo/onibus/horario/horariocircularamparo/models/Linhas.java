package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public class Linhas  {

    private int id;
    private String descricao;




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
