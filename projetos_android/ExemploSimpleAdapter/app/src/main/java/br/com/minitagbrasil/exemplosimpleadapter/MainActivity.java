package br.com.minitagbrasil.exemplosimpleadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private static final String[] menuItens = new String[] {"Exemplo SimpleAdater 1", "Exemplo SimpleAdapter customizado", "Sair"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuItens);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it;

        switch (position) {

            case 0:
                 it = new Intent(this, ExemploSimpleAdapterActivity.class);
                startActivity(it);
                break;
            case 1:
                it = new Intent(this, ExemploSimpleAdapterComCustonLayoutActivity.class);
                startActivity(it);
            default:
                finish();
        }
    }
}
