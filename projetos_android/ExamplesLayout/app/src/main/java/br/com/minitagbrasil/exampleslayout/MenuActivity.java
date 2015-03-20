package br.com.minitagbrasil.exampleslayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.minitagbrasil.exampleslayout.activities.framelayout.MainFrameLayoutActivity;


public class MenuActivity extends ListActivity {

    private static final String[] options = new String[] {
            "Examples FrameLayout",
            "Sair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cria o adapter contendo o menu
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, options);

        //seta o adapter na activity
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position){
            case 0:
                Intent it = new Intent(this, MainFrameLayoutActivity.class);
                startActivity(it);
                break;
            default:
                finish();
        }

    }
}
