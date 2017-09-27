package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiasSemana extends AppCompatActivity {
    @BindView(R.id.lista_semanas) ListView lista;
    String idLinhas;
    ArrayList<HashMap<String, String>> semanaList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_semana);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Voltar");
        ButterKnife.bind(this);
        idLinhas = getIntent().getStringExtra("semana");
        semanaList = new  ArrayList<>();
        criarListagem();

    }//fim do oncreate

    private void criarListagem() {
        try {
            JSONArray jsonArray = new JSONArray(idLinhas);
            int length = jsonArray.length();
            for (int i = 0; i < length; i++)
            {
                JSONObject itens = jsonArray.getJSONObject(i);
                String dias1 = itens.getString("dias");
                HashMap<String, String> listasemana = new HashMap<>();
                listasemana.put("dias", dias1);
                semanaList.add(listasemana);
            }//fim do for

            ListAdapter adapter = new SimpleAdapter(
                    DiasSemana.this, semanaList,
                    R.layout.item_listar_semana, new String[]{"dias"},
                    new int[]{R.id.txtsemana});

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    Toast.makeText(DiasSemana.this, "clicou na semana", Toast.LENGTH_LONG).show();


                }
            });

            lista.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        } // fim do catch

    }// fim do metodo criarListagem






    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
