package br.com.minitagbrasil.examplesbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ggarcia on 11/06/15.
 */
public class ExampleReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //don't use a BroadCast receiver to show messages, this is only an example !
        Toast.makeText(context, "ExampleReceiver1", Toast.LENGTH_SHORT).show();
    }
}
