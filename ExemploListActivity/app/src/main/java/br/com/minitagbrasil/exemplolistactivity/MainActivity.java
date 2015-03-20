package br.com.minitagbrasil.exemplolistactivity;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        //Array de Strings para visualizacao
        String[] itens = new String[] {"Nome 1", "Nome 2", "Nome 3"};

        //adaptador para setar no ListAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        setListAdapter(arrayAdapter);
    }


    protected void onListItemClick(ListView l,View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        //recupera o item na posicao
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        //exibe um alerta
        Toast.makeText(this, "Item selecionado: "+item, Toast.LENGTH_SHORT).show();

    }


}
