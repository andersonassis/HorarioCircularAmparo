package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.holders;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.DiasSemana;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.R;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.Linhas;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public final class LinhaHolders extends RecyclerView.ViewHolder {
    @BindView(R.id.txtnome) public TextView txtdescricao;
    public Linhas linhas;
    public int id;
    public String descr;
    Context c;

    public LinhaHolders(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_linhas, parent, false));

        ButterKnife.bind(this, itemView);



        // clica na categoria
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c = v.getContext();
                try {
                    id            = linhas.getId();
                    descr  = linhas.getDescricao();

                    Intent intent = new Intent(c,DiasSemana.class);
                    intent.putExtra("id_categoria", Long.toString(linhas.getId()));
                    c.startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


    }//FIM AREA HOLDE

}
