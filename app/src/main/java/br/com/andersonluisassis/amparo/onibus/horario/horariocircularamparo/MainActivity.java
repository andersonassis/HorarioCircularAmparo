package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.Toast.ToastManager;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.adapter.LinhaAdapter;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.models.Linhas;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.testarConexao.TestarConexao;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.testarConexao.VerificarConexao;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference data_reference;
    private DatabaseReference data_reference2;
    public List<Linhas> lista = new ArrayList<>();
    private LinhaAdapter adaptador;
    @BindView(R.id.recyclerView) RecyclerView  reciclada;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Verificando conexao com internet
        boolean conexao = TestarConexao.verificaConexao(this);
        if (conexao) {
            ToastManager.show(MainActivity.this, "Conectado a Internet", ToastManager.INFORMATION);
        } else {
            ToastManager.show(MainActivity.this, "Sem Conexão com Internet,Verifique", ToastManager.INFORMATION);
            startActivity(new Intent(MainActivity.this, VerificarConexao.class));
            finish();

        }
        data_reference  = database.getReference().child("linhas");
        data_reference.addValueEventListener(this);

    }//fim do oncreate

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            cont++;
            try {
                Linhas objeto = snapshot.getValue(Linhas.class);
                lista.add(objeto);
            }catch (Exception e){

                e.printStackTrace();
            }

        }//fim do for
        adaptador = new LinhaAdapter(reciclada.getContext(),lista);
        reciclada.setAdapter(adaptador);
        reciclada.setHasFixedSize(true);
        reciclada.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        ToastManager.show(MainActivity.this, "ERRO DE CONEXÃO COM O BANCO DE DADOS", ToastManager.INFORMATION);
    }
}
