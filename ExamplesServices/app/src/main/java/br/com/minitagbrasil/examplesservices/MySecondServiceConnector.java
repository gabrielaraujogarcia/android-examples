package br.com.minitagbrasil.examplesservices;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ggarcia on 30/06/15.
 */
public class MySecondServiceConnector extends Activity implements ServiceConnection {

    private static final String CATEGORY = "MySecondServiceConector";
    private ICounter iCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_second_service_connector);

        //class that implements the ServiceConnection interface
        final ServiceConnection connection = this;

        Button btnStart = (Button) findViewById(R.id.btnStartBinding);

        //connect with the service
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.i(CATEGORY, "Start service from bindService");
                Intent service = new Intent(MySecondServiceConnector.this, MySecondService.class);

                //starts the service
                startService(service);
                //TODO does not work: Context.BIND_AUTO_CREATE starts the service if its necessary
                //bindService(service, connection, Context.BIND_AUTO_CREATE);

                //connect to service
                bindService(service, connection, 0);

            }

        });

        Button btnStop = (Button) findViewById(R.id.btnStopBinding);

        //stop the  connection with the service
        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(CATEGORY, "Stop service from unbindService");
                unbindService(connection);
            }

        });

        Button btnShowCount = (Button) findViewById(R.id.btnShowCount);

        //show count
        btnShowCount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(CATEGORY, "Show count from interface of service");
                int count = iCount.count();
                Toast.makeText(MySecondServiceConnector.this, "Count: "+count, Toast.LENGTH_SHORT)
                    .show();
            }

        });
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        //get the interface to interact with the service
        MySecondService.LocalBinder binder = (MySecondService.LocalBinder) service;
        iCount = binder.getCounter();

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        iCount = null;
    }
}
