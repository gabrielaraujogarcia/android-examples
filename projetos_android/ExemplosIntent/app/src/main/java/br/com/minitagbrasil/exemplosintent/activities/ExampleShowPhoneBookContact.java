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
public class ExampleShowPhoneBookContact extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //adiciona o layout a activity (tela)
        setContentView(R.layout.show_phonebook_contact);

        final Button btnShowContact = (Button) findViewById(R.id.btnShowContact);
        btnShowContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        /**
         * O padrao do android para identificar os contatos e "content://com.android.contacts/contacts/1",
         * onde 1 indica o id do contato que deve ser visualizado.
         */

        //visualizar o contato 1 da lista de contatos
        Uri uri = Uri.parse("content://com.android.contacts/contacts/1");

        //cria a intent
        Intent it = new Intent(Intent.ACTION_VIEW, uri);

        //envia a mensagem ao sistema operacional
        startActivity(it);

    }
}
