package br.com.minitagbrasil.exemplosintent.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.minitagbrasil.exemplosintent.R;

/**
 * Created by ggarcia on 17/03/15.
 */
public class ExampleOpenBrowser extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_browser);

        final Button btnGo = (Button) findViewById(R.id.btnSend);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText txtUrl = (EditText) findViewById(R.id.txtUrl);
        String url = txtUrl.getText().toString();

        //transforma a URL em uma URI para ser interpretada por uma aplicacao no Android
        Uri uri = Uri.parse(url);

        //intent para abrir a aplicacao do navegador na URI
        Intent it = new Intent(Intent.ACTION_VIEW, uri);

        //envia a mensagem para o sistema operacional que abre a aplicacao do browse na URL
        startActivity(it);

    }
}
