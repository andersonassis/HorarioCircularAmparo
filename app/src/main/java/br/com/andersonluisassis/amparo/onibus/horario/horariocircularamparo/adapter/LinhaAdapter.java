package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.holders.LinhaHolders;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.Linhas;

/**
 * Created by AndersonLuis on 26/09/2017.
 */

public class LinhaAdapter extends RecyclerView.Adapter<LinhaHolders>  {
    private List<Linhas> lista;
    private Context context;

    public LinhaAdapter (Context context, List<Linhas> lista) {
        this.lista      = lista;
        this.context    = context;
    }

    @Override
    public LinhaHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinhaHolders(LayoutInflater.from(parent.getContext()), parent);

    }

    @Override
    public void onBindViewHolder(LinhaHolders holder, int i) {
        Linhas objeto = lista.get(i);
        holder.txtdescricao.setText(objeto.getDescricao());
        holder.linhas = objeto;
    }

    @Override
    public int getItemCount() {
        return (null != lista ? lista.size() : 0 );
    }
}
