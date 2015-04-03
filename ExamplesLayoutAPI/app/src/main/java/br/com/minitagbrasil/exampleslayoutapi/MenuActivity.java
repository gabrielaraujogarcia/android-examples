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
            "Create LinearLayout from Activity (hardcore mode)",
            "ScrollView",
            "GridView",
            "Gallery"
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create the ListAdapter
        ArrayAdapter<String> items = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menuItens);

        setListAdapter(items);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it;

        switch (position) {
            case 0:
                it = new Intent(this, ExampleLinearLayoutAPI.class);
                startActivity(it);
                break;
            case 1:
                it = new Intent(this, ExampleScrollView.class);
                startActivity(it);
                break;
            case 2:
                it = new Intent(this, ExampleGridView.class);
                startActivity(it);
                break;
            case 3:
                it = new Intent(this, ExampleGallery.class);
                startActivity(it);
                break;
            default:
                finish();
        }
    }
}
