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

        doMyFirstService();
        doMultThreadService();
        doMySecondService();
        doIntentService();

    }

    private void doMyFirstService(){

        final Button btnStart = (Button) findViewById(R.id.btnStartMyFirstService);
        final Button btnStop = (Button) findViewById(R.id.btnStopMyFirstService);
        final Intent myService = new Intent("MY_FIRST_SERVICE");

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

    }

    private void doMultThreadService(){

        final Button btnStartMulti = (Button) findViewById(R.id.btnStartMultiThreadingService);
        final Button btnStopMulti = (Button) findViewById(R.id.btnStopMultiThreadingService);
        final Intent multiThreadService = new Intent("MULTI_THREADING_SERVICE");

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

    private void doMySecondService(){

        final Button btnMySecondService = (Button) findViewById(R.id.btnOpenMySecondService);

        btnMySecondService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this, MySecondServiceConnector.class);
                startActivity(it);

            }


        });

    }

    private void doIntentService(){

        final Button btnStartIntentService = (Button) findViewById(R.id.btnStartIntentService);
        final Button btnStopIntentService = (Button) findViewById(R.id.btnStopIntentService);
        final Intent myIntentService = new Intent("MY_INTENT_SERVICE");

        btnStartIntentService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startService(myIntentService);
            }

        });

        btnStopIntentService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stopService(myIntentService);
            }

        });

    }
}
