package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    @BindView(R.id.progressbar) ProgressBar progress;
    @BindView(R.id.texto_bar)TextView textobar;



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
        //conectando ao firebase no linhas
        firebase();
        progress.setVisibility(View.VISIBLE);



    }//fim do oncreate

    private void firebase() {
        data_reference  = database.getReference().child("linhas");
        data_reference.addValueEventListener(this);
    }

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
        progress.setVisibility(View.INVISIBLE);
        textobar.setText(getString(R.string.statusbar2));


    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        ToastManager.show(MainActivity.this, "ERRO DE CONEXÃO COM O BANCO DE DADOS", ToastManager.INFORMATION);
    }




    // INICIO DOS MENUS QUE INCLUI O BOTÃO SAIR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        if (id == R.id.sobre) { // CLICK DO BOTÃO sobre
            Intent intent = new Intent(getApplicationContext(), Sobre.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//fim do menu sobre


    @Override
     public void onBackPressed(){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ATENÇÃO!!!");
        builder.setMessage("DESEJA SAIR DO APLICATIVO ?");
        builder.setPositiveButton("SAIR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    }//FIM DO onBackPressed


}
