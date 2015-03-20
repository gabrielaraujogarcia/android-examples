package br.com.minitagbrasil.exemplosimpleadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ggarcia on 16/03/15.
 */
public class ExemploSimpleAdapterComCustonLayoutActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sobrescreve o layout padrao do ListView do Android
        setContentView(R.layout.layout_listview_contatos); //linha opcional

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

        //agora com um layout customizado
        int[] to = new int[] {R.id.nome, R.id.fone};

        setListAdapter(new SimpleAdapter(this, list, R.layout.layout_contatos_fone, from, to));
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
