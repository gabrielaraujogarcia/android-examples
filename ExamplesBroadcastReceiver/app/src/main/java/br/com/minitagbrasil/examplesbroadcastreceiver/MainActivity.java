package br.com.minitagbrasil.examplesbroadcastreceiver;

import android.app.ListActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private static final String[] options = new String[] {
            "Call Broadcast Receiver 1",
            "Call Broadcast Receiver 2",
            "Exit"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create an ArrayAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));

        //register the broadcast receiver ExampleReceiver2 with Java API (dynamicallly). It's useful
        //when we need to execute a broadcast receive only when this activity are executing
        registerReceiver(new ExampleReceiver2(), new IntentFilter("OPEN_RECEIVER_2"));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position){
            case 0:
                //call broadcast receiver 1
                sendBroadcast(new Intent("OPEN_RECEIVER_1"));;
                break;
            case 1:
                sendBroadcast(new Intent("OPEN_RECEIVER_2"));
                break;
            case 3:
                finish();
                break;
            default:
                finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //remove the broadcast receiver created dinamically. It's mandatory when it is created dinamically
        unregisterReceiver(new ExampleReceiver2());
    }
}
