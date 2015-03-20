package br.com.minitagbrasil.exemplosintent.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.minitagbrasil.exemplosintent.R;

/**
 * Created by ggarcia on 17/03/15.
 */
public class ExampleCallTelephone extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //devemos setar a view primeiro para que o botao passe a existir no contexto
        setContentView(R.layout.call_number);

        final Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //representa o endereco que desejamos abrir
        //o padrao de mensagem para executar uma intent para telefonar e tel:999999999
        Uri uri = Uri.parse("tel:999908080");

        //cria a Intent com o endereco
        Intent it = new Intent(Intent.ACTION_CALL, uri);

        //envia a mensagem ao sistema operacional
        startActivity(it);

    }
}
