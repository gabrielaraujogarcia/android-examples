package br.com.minitagbrasil.shootintentfilter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayMe();
        displayIt();
        callBroadcastReceiver1();
        callBroadcastReceiver2();
    }

    private void displayMe(){

        Button btn = (Button) findViewById(R.id.btnDisplayMe);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //open the activity that was mapped on project ExemplosIntent on intent-filter
                //in AndroidManifest.xml
                Intent it = new Intent("ACTION_TEST");
                it.putExtra("message", "Opened by SHootIntentFilter app!");
                startActivity(it);

            }

        });

    }

    private void displayIt(){

        Button btn = (Button) findViewById(R.id.btnDisplayIt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //start an activity mapped in AndroidManifes.xml by an intent-filter with custom
                //category to identify/differencing of DisplayMeActivity intent-filter name
                Intent it = new Intent("ACTION_TEST");
                it.addCategory("CUSTOM_CATEGORY");
                it.putExtra("message", "When using custom category, we don't have conflict!");
                startActivity(it);

            }

        });

    }

    private void callBroadcastReceiver1(){

        Button btn = (Button) findViewById(R.id.btnCallReceiver1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //Test call the broadcast receiver 1 on ExamplesBroadcastReceiver project. This call
            //should only work if the application is open
            //The ExamplesBroadcastReceive project need to be installed on your device
            sendBroadcast(new Intent("OPEN_RECEIVER_1"));;

            }

        });

    }

    private void callBroadcastReceiver2(){

        Button btn = (Button) findViewById(R.id.btnCallReceiver2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //Test a call to the BroadcastReceiver 2 on ExamplesBroadcastReceiver project. This call
            //should only work if the application is open
            //The ExamplesBroadcastReceive project need to be installed on your device
            sendBroadcast(new Intent("OPEN_RECEIVER_2"));

            }

        });

    }

}