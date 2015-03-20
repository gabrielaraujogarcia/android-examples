package br.com.minitagbrasil.exemplosintent.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.minitagbrasil.exemplosintent.R;

/**
 * Created by ggarcia on 18/03/15.
 */
public class ExampleReturnResultFromCustomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seta a tela
        setContentView(R.layout.yes_no);

        Button btnYes = (Button) findViewById(R.id.btnYes);

        //outra forma de implementar o evento de escuta do click no botao, similar a um callback
        btnYes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //cria a intent
                Intent it = new Intent();

                //seta a mensagem de retorno
                it.putExtra("msg", "Clicou em sim!");

                //seta o status do resultado e da Intent
                setResult(1, it);

                //finaliza a activity
                finish();
            }

        });

        Button btnNo = (Button) findViewById(R.id.btnNo);

        btnNo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //cria a intent
                Intent it = new Intent();

                //adiciona a mensagem na Intent
                it.putExtra("msg", "Clicou em não");

                //seta a intent no result
                setResult(2, it);

                //finaliza a activity
                finish();
            }

        });

    }
}
