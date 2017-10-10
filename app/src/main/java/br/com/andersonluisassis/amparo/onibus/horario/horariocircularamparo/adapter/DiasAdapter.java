package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.holders.DiasHolder;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.DiasSemanaModel;

/**
 * Created by AndersonLuis on 02/10/2017.
 */

public class DiasAdapter  extends RecyclerView.Adapter<DiasHolder> {
    private List<DiasSemanaModel> lista;
    private Context context;

    public DiasAdapter(Context context, List<DiasSemanaModel> lista) {
        this.lista      = lista;
        this.context    = context;
    }

    @Override
    public DiasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiasHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(DiasHolder holder, int i) {
        DiasSemanaModel objeto = lista.get(i);
        holder.txtsemana.setText(objeto.getDescricao());
        holder.semana = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
