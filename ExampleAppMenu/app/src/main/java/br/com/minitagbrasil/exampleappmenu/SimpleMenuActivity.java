package br.com.minitagbrasil.exampleappmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ggarcia on 20/05/15.
 */
public class SimpleMenuActivity extends Activity {

    public static final int ID_NEW = 0;
    public static final int ID_SAVE = 1;
    public static final int ID_DELETE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText(R.string.simple_menu);
        setContentView(text);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //add 3 menus on activity
        menu.add(0,ID_NEW, 0, R.string.lbl_new);
        menu.add(0, ID_SAVE, 0, R.string.lbl_save);
        menu.add(0, ID_DELETE, 0, R.string.lbl_delete);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        super.onMenuItemSelected(featureId, item);

        switch (item.getItemId()){
            case ID_NEW:
                Toast.makeText(this, R.string.txt_choose_new, Toast.LENGTH_SHORT).show();
                return true;
            case ID_SAVE:
                Toast.makeText(this, R.string.txt_choose_save, Toast.LENGTH_SHORT).show();
                return true;
            case ID_DELETE:
                Toast.makeText(this, R.string.txt_choose_delete, Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }
}
