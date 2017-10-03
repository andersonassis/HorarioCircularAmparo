package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.Toast.ToastManager;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter.HorariosAdapter;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.DiasSemanaModel;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.HorariosModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Horarios extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    @BindView(R.id.listview) ListView listview;
    public List<HorariosModel> lista = new ArrayList<>();
    Context c;
    int cont = 0;

    String horarios;
    String dias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Voltar");
        ButterKnife.bind(this);
        horarios = getIntent().getStringExtra("id_horarios");
        dias     = getIntent().getStringExtra("dia");

        if (dias.equals("Segunda à Sexta")){
            dias = "segunda";
        }else if (dias.equals("Sábados")){
            dias = "sabados";

        }else if (dias.equals("Domingos e Feriados")){
            dias = "domingos";
        }else{
            dias = "outro";
        }

        data_reference = database.getReference().child("horarios").child(horarios).child(dias);
        data_reference.addValueEventListener(this);


    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            HorariosModel objeto = snapshot.getValue(HorariosModel.class);
            lista.add(objeto);
        }//fim do for

        listview.setAdapter(new HorariosAdapter(this, (ArrayList<HorariosModel>) lista));

    }


    @Override
    public void onCancelled(DatabaseError databaseError) {
        ToastManager.show(Horarios.this, "ERRO DE CONEXÃO COM O BANCO DE DADOS", ToastManager.INFORMATION);
    }







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
