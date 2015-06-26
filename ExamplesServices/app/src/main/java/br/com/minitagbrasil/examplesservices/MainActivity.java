package br.com.minitagbrasil.examplesservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ggarcia on 25/06/15.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStart = (Button) findViewById(R.id.btnStartMyFirstService);
        final Button btnStop = (Button) findViewById(R.id.btnStopMyFirstService);
        final Button btnStartMulti = (Button) findViewById(R.id.btnStartMultiThreadingService);
        final Button btnStopMulti = (Button) findViewById(R.id.btnStopMultiThreadingService);

        final Intent myService = new Intent("MY_FIRST_SERVICE");
        final Intent multiThreadService = new Intent("MULTI_THREADING_SERVICE");

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startService(myService);
            }

        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopService(myService);
            }

        });

        btnStartMulti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startService(multiThreadService);
            }

        });

        btnStopMulti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopService(multiThreadService);
            }

        });

    }
}
