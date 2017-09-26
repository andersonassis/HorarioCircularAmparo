package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.testarConexao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.MainActivity;
import br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo.R;

public class VerificarConexao extends AppCompatActivity {
    private Button verifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_conexao);
        verifica = (Button)findViewById(R.id.btn_tentar_novamente);
        verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerificarConexao.this,MainActivity.class));
                finish();
            }
        });


    }
}
