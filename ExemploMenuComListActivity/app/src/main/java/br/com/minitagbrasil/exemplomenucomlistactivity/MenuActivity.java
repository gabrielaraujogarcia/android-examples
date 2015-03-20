package br.com.minitagbrasil.exemplomenucomlistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuActivity extends ListActivity {

    private static final String[] nomes = new String[]{
            "Ciclo de vida", "ArrayAdapter", "SimpleAdapter 1", "SimpleAdapter 2", "CursorAdapter 1",
            "CursorAdapter 2", "Cursor de Carros", "Customizado - Smile", "MapActivity",
            "MapActivity - Cristo", "Sair"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position){

            case 0:
                //startActivity(new Intent(this, ExemploCicloVida.class));
                break;
            case 1:
                //startActivity(new Intent(this, ExemploCicloVida.class));
                break;
            case 2:
                //startActivity(new Intent(this, ExemploCicloVida.class));
                break;
            case 3:
                //startActivity(new Intent(this, ExemploCicloVida.class));
                break;
            default:
                //fecha a acitvity (encerra o ciclo de vida)
                finish();
        }
    }



}