package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public class Linhas  {

    private int id;

    public int getIdseg() {
        return idseg;
    }

    public void setIdseg(int idseg) {
        this.idseg = idseg;
    }

    public int getIdsab() {
        return idsab;
    }

    public void setIdsab(int idsab) {
        this.idsab = idsab;
    }

    public int getIdsexta() {
        return idsexta;
    }

    public void setIdsexta(int idsexta) {
        this.idsexta = idsexta;
    }

    public int getIddom() {
        return iddom;
    }

    public void setIddom(int iddom) {
        this.iddom = iddom;
    }

    private int idseg;
    private int idsab;
    private int idsexta;
    private int iddom;
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
