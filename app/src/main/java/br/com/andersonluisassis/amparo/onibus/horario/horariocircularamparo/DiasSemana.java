package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.Toast.ToastManager;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter.DiasAdapter;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.DiasSemanaModel;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.Linhas;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DiasSemana extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    public List<DiasSemanaModel> lista = new ArrayList<>();
    @BindView(R.id.recyclerView) RecyclerView view_reciclada;
    String idLinhas;
    private DiasAdapter adaptador;
    Context c;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_semana);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Voltar");
        ButterKnife.bind(this);

        idLinhas = getIntent().getStringExtra("id_linha");
        data_reference = database.getReference().child("semanas").child(idLinhas);
        data_reference.addValueEventListener(this);

    }//fim do oncreate


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            DiasSemanaModel objeto = snapshot.getValue(DiasSemanaModel.class);
            lista.add(objeto);
        }
        adaptador = new DiasAdapter (view_reciclada.getContext(), lista);
        view_reciclada.setAdapter(adaptador);
        view_reciclada.setHasFixedSize(true);
        view_reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        ToastManager.show(DiasSemana.this, "ERRO DE CONEXÃO COM O BANCO DE DADOS", ToastManager.INFORMATION);

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
}//fim da classe Dias semana
