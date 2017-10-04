package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.R;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.HorariosModel;

/**
 * Created by AndersonLuis on 04/10/2017.
 */

public class AdaptadorNovo extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private List<HorariosModel> horarios = null;
    private ArrayList<HorariosModel> arraylist;

    public AdaptadorNovo(Context context, List<HorariosModel> worldpopulationlist) {
        mContext = context;
        this.horarios = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<HorariosModel>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView saida;
        TextView hora;
        TextView descricao;
    }

    @Override
    public int getCount() {
        return horarios.size();
    }

    @Override
    public HorariosModel getItem(int position) {
        return horarios.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_item, null);
            // Locate the TextViews in listview_item.xml
            holder.saida = (TextView) view.findViewById(R.id.saida);
            holder.hora  = (TextView) view.findViewById(R.id.hora);
            holder.descricao = (TextView) view.findViewById(R.id.descricao);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set the results into TextViews
        holder.saida.setText(horarios.get(i).getSaida());
        holder.hora.setText(horarios.get(i).getHora());
        holder.descricao.setText(horarios.get(i).getDescricao());

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        horarios.clear();
        if (charText.length() == 0) {
            horarios.addAll(arraylist);
        }
        else
        {
            for (HorariosModel wp : arraylist)
            {
                if (wp.getSaida().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    horarios.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
