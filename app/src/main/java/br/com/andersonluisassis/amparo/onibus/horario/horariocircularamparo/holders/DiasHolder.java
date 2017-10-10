package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.holders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.DiasSemana;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.Horarios;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.R;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.DiasSemanaModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AndersonLuis on 02/10/2017.
 */

public class DiasHolder  extends RecyclerView.ViewHolder {
    @BindView(R.id.txtsemana) public TextView txtsemana;
    public DiasSemanaModel semana;
    Context c;
    public int id;

    public DiasHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_listar_semana, parent, false));
        ButterKnife.bind(this, itemView);

        // clica na categoria
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c = v.getContext();
                TextView txt_Nome = (TextView)v.findViewById(R.id.txtsemana);
                String dia = txt_Nome.getText().toString();
                id            = semana.getId();

                Intent intent = new Intent(c,Horarios.class);
                intent.putExtra("id_horarios", Long.toString(id));
                intent.putExtra("dia",dia);
                c.startActivity(intent);

            }
        });

    }

}

