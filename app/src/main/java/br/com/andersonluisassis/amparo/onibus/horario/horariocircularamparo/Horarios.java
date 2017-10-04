package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.Toast.ToastManager;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter.AdaptadorNovo;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.HorariosModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Horarios extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    @BindView(R.id.listview) ListView listview;
    @BindView(R.id.search) EditText procurar;
    public List<HorariosModel> lista = new ArrayList<>();
    private AdaptadorNovo adaptador;
    int cont = 0;
    HorariosModel objeto;
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

        //inicia o firebase
       firebase();


       //campo buscar
        procurar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = procurar.getText().toString().toLowerCase(Locale.getDefault());
                adaptador.filter(text);
            }
        });


    }//fim do oncreate

    public void firebase(){
        data_reference = database.getReference().child("horarios").child(horarios).child(dias);
        data_reference.addValueEventListener(this);

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            objeto = snapshot.getValue(HorariosModel.class);
            lista.add(objeto);
        }//fim do for

        adaptador = new AdaptadorNovo(this, lista);
        listview.setAdapter(adaptador);

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
