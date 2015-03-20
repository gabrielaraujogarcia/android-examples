package br.com.minitagbrasil.exemplosimpleadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by ggarcia on 16/03/15.
 */
public class ExemploSimpleAdapterActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lista de itens
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        //cada item de uma linha precisa ser um HashMap
        //O HashMap contem as chaves e valores necessarios para preencher os elementos da tela
        for(int i = 0; i < 10; i++){
            HashMap<String, String> item = new HashMap<>();
            item.put("nome", "Nome "+i);
            item.put("fone", "Fone "+i);
            list.add(item);
        }

        //utilizar o adaptador SimpleAdapter
        //Array que define as chaves do HashMap
        String[] from = new String[] {"nome", "fone"};

        //text1 e tex3 sao os padroes do android para o layout nativo "two_line_list_item"
        int[] to = new int[] {android.R.id.text1, android.R.id.text2};
        int layoutNativo = android.R.layout.two_line_list_item;

        setListAdapter(new SimpleAdapter(this, list, layoutNativo, from, to));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //a superclasse ListActivity possui um ListAdapter sem que precisemos declara-lo
        //recupera o item da posicao
        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }
}
