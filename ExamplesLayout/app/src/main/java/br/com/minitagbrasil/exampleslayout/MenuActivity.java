package br.com.minitagbrasil.exampleslayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.minitagbrasil.exampleslayout.activities.framelayout.MainFrameLayoutActivity;
import br.com.minitagbrasil.exampleslayout.activities.linearlayout.MainLinearLayout;
import br.com.minitagbrasil.exampleslayout.activities.relativelayout.MainRelativeLayout;
import br.com.minitagbrasil.exampleslayout.activities.tablelayout.MainTableLayout;


public class MenuActivity extends ListActivity {

    private static final String[] options = new String[] {
            "Examples FrameLayout",
            "Examples LinearLayout",
            "Examples TableLayout",
            "Examples RelativeLayout",
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

        Intent it;

        switch (position){

            case 0:
                it = new Intent(this, MainFrameLayoutActivity.class);
                startActivity(it);
                break;
            case 1:
                it = new Intent(this, MainLinearLayout.class);
                startActivity(it);
                break;
            case 2:
                it = new Intent(this, MainTableLayout.class);
                startActivity(it);
                break;
            case 3:
                it = new Intent(this, MainRelativeLayout.class);
                startActivity(it);
                break;
            default:
                finish();
        }

    }
}
