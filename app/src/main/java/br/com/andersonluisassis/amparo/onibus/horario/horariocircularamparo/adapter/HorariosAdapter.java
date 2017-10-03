package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.R;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.HorariosModel;

/**
 * Created by AndersonLuis on 03/10/2017.
 */

public class HorariosAdapter extends BaseAdapter {
    private ArrayList<HorariosModel> personArray;
    private LayoutInflater inflater;
    private static final int TYPE_PERSON = 0;
    private static final int TYPE_DIVIDER = 1;
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    public HorariosAdapter(Context context, ArrayList<HorariosModel> personArray) {
        this.personArray = personArray;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return personArray.size();
    }

    @Override
    public Object getItem(int position) {
        return personArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getViewTypeCount() {
        // TYPE_PERSON and TYPE_DIVIDER
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_DIVIDER : TYPE_PERSON;
    }

    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_PERSON);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        if (convertView == null) {
            switch (type) {
                case TYPE_PERSON:
                    convertView = inflater.inflate(R.layout.row_item, parent, false);
                    break;
                case TYPE_DIVIDER:
                    convertView = inflater.inflate(R.layout.row_header, parent, false);
                    break;
            }
        }

        switch (type) {
            case TYPE_PERSON:
                HorariosModel person = (HorariosModel)getItem(position);
                TextView titulo = (TextView)convertView.findViewById(R.id.headerTitle1);
                TextView hora   = (TextView)convertView.findViewById(R.id.nameLabel);
                TextView descr  = (TextView)convertView.findViewById(R.id.addressLabel);
                //String cor = person.getSaida();
                titulo.setText(person.getSaida());
                hora.setText(person.getHora());
                descr.setText("Linha: "+person.getDescricao());
                break;
            case TYPE_DIVIDER:
                HorariosModel person2 = (HorariosModel)getItem(position);
                TextView title = (TextView)convertView.findViewById(R.id.headerTitle);
                title.setText(person2.getSaida());
                break;
        }

           return convertView;
       }
    }


