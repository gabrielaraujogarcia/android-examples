package br.com.minitagbrasil.exampleslayoutapi;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MenuActivity extends ListActivity {

    private static final String[] menuItens = new String[] {
            "Create LinearLayout from Activity (hardcore mode)"
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cria o ListAdapter
        ArrayAdapter<String> itens = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuItens);

        //seta o ListAdapter
        setListAdapter(itens);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it;

        switch (position) {
            case 0:
                it = new Intent(this, ExampleLinearLayoutAPI.class);
                startActivity(it);
            default:
                finish();
        }
    }
}
