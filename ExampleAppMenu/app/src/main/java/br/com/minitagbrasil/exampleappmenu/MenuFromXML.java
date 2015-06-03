package br.com.minitagbrasil.exampleappmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by ggarcia on 02/06/15.
 */
public class MenuFromXML extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //inflate the menu XML file
        getMenuInflater().inflate(R.menu.example_menu, menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        super.onMenuItemSelected(featureId, item);

        switch (item.getItemId()){
            case R.id.itemNew:
                Toast.makeText(MenuFromXML.this, R.string.txt_choose_new, Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemSave:
                Toast.makeText(MenuFromXML.this, R.string.txt_choose_save, Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemDelete:
                Toast.makeText(MenuFromXML.this, R.string.txt_choose_delete, Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
