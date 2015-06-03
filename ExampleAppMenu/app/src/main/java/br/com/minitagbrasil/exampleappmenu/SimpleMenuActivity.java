package br.com.minitagbrasil.exampleappmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ggarcia on 20/05/15.
 */
public class SimpleMenuActivity extends Activity {

    public static final int ID_NEW = 0;
    public static final int ID_SAVE = 1;
    public static final int ID_DELETE = 2;
    public static final int ID_SEARCH = 3;
    public static  final int ID_CLEAN = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText(R.string.simple_menu);
        setContentView(text);

    }

    //That method works too
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        //add 3 menus on activity
//        menu.add(0, ID_NEW, 0, R.string.lbl_new);
//        menu.add(0, ID_SAVE, 0, R.string.lbl_save);
//        menu.add(0, ID_DELETE, 0, R.string.lbl_delete);
//
//        return true;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //add 3 menus on activity
        MenuItem item = menu.add(0, ID_NEW, 0, R.string.lbl_new);
        item.setIcon(R.drawable.new_24x24);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        item = menu.add(0, ID_SAVE, 0, R.string.lbl_save);
        item.setIcon(R.drawable.save_black_24x24);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        item = menu.add(0, ID_DELETE, 0, R.string.lbl_delete);
        item.setIcon(R.drawable.red_cross_24x24);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        //create submenu
        SubMenu subMenu = menu.addSubMenu(R.string.lbl_others);
        subMenu.setIcon(R.drawable.plus_24x24);

        //add submenu itens
        item = subMenu.add(0, ID_SEARCH, 0, R.string.lbl_search);
        item.setIcon(R.drawable.search_24x24);

        item = subMenu.add(0, ID_CLEAN, 0, R.string.lbl_clean);
        item.setIcon(R.drawable.clean_22x22);

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
            case ID_SEARCH:
                Toast.makeText(this, R.string.txt_choose_search, Toast.LENGTH_SHORT).show();
                return true;
            case ID_CLEAN:
                Toast.makeText(this, R.string.txt_choose_clean, Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "Duh!?", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
