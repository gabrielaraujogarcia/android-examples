package br.com.minitagbrasil.exemplosintent.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.minitagbrasil.exemplosintent.R;

/**
 * Created by ggarcia on 18/03/15.
 */
public class ExamplePickPhoneBookContact extends Activity implements View.OnClickListener {

    //constante qualquer para identificar esta activity quando chamado o metodo startActivityForResult
    private static final int SELECIONAR_CONTATO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //seta a view da activity
        setContentView(R.layout.pick_contact);

        //recupera o botao do layout pelo id
        final Button btnSelectContacts = (Button) findViewById(R.id.btnSelectContact);
        btnSelectContacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //URI para visualizar a lista de contatos e selecionar
        Uri uri = Uri.parse("content://com.android.contacts/contacts/");

        //Intent para exibir a lista
        Intent it = new Intent(Intent.ACTION_PICK, uri);

        //inicia a activity
         startActivityForResult(it, SELECIONAR_CONTATO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Intent data e o retorno da activity chamada no metodo startActivityForResult
        if(data == null){
            Toast.makeText(this, R.string.nothink_selected, Toast.LENGTH_SHORT).show();
            return;
        }

        //URI para visualizar o contato selecionado
        Uri uri = data.getData();

        //exibir a mensagem com a uri do contato
        //Toast.makeText(this, R.string.select_contact + " " + uri, Toast.LENGTH_SHORT).show();

        //intent para visualizar o contato selecionado
        Intent it = new Intent(Intent.ACTION_VIEW, uri);

        //visualizar o contato selecionado
        startActivity(it);
    }
}
