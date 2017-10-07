package br.com.andersonluisassis.amparo.onibus.horario.horariocircularamparo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                String[] to = {"desenvolvedorandersonassis@gmail.com","anderson1460@hotmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL,to);
                email.putExtra(Intent.EXTRA_SUBJECT,"Aplicativo horarios circular");
                email.putExtra(Intent.EXTRA_TEXT,"escreva sua mensagem aqui");
                email.setType("message/rfc822");
                Intent escolha = Intent.createChooser(email,"Enviar Email");
                startActivity(escolha);


            }
        });


    }//fim do oncreate

}
