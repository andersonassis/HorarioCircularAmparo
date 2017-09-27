package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

import java.util.List;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public class Linhas  {

    private int id;
    private String descricao;
    private int user_id;
    private List<DiasSemana> semana;

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


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<DiasSemana> getSemana() {
        return semana;
    }

    public void setSemana(List<DiasSemana> semana) {
        this.semana = semana;
    }
}
