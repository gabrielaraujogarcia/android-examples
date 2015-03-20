package br.com.minitagbrasil.exemplolistarcontatosagenda;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    //ArrayAdapter para exibir a lista
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //URI para buscar os contatos
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        //recupera o cursor dos contatos. Um cursor e semelhante a um ResultSet
        Cursor c = getContentResolver().query(uri, null, null, null, null);

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //percorrer os elemetos do cursor (contatos da agenda)
        while(c.moveToNext()) {

            //le a coluna nome e  adiciona no adapter
            //index da coluna display_name do contrato de contatos pre definido na API do android
            int index = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            adaptador.add(c.getString(index));
        }

        //informa o adapter responsavel por exibir a lista do ListActivity
        setListAdapter(adaptador);

        //podemos fechar o cursor depois de utiliza-lo
        c.close();

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String s = adaptador.getItem(position);
        Toast.makeText(this, "Contato clicado: "+ s, Toast.LENGTH_SHORT).show();
    }

}
