package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class DiasSemana extends AppCompatActivity {
    private String idLinhas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dias_semana);
        ButterKnife.bind(this);

        idLinhas = getIntent().getStringExtra("id_categoria");




    }
}
