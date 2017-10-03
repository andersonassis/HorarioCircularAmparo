package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class Horarios extends AppCompatActivity {
    String jsonHorarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Voltar");
        ButterKnife.bind(this);

        jsonHorarios = getIntent().getStringExtra("horarios");



    }//fim do oncreate
}
