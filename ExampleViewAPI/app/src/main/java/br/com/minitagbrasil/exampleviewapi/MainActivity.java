package br.com.minitagbrasil.exampleviewapi;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private static final String[] items = new String[] {
        "Custom Resources",
        "TextView elements",
         "TextView auto complete",
         "Button and ImageButton",
         "CheckBox and ToggleButton"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent it;

        switch (position){
            case 0:
                it = new Intent(this, ExampleCustonResources.class);
                startActivity(it);
                break;
            case 1:
                it = new Intent(this, ExampleTextViewAndEditText.class);
                startActivity(it);
                break;
            case 2:
                it = new Intent(this, ExampleAutoCompleteTextView.class);
                startActivity(it);
                break;
            case 3:
                it = new Intent(this, ExampleButtonImageButton.class);
                startActivity(it);
                break;
            case 4:
                it = new Intent(this, ExampleCheckBoxToggleButton.class);
                startActivity(it);
                break;
        }
    }
}
