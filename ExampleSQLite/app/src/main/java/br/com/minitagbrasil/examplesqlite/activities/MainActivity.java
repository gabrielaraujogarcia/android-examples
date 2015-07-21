package br.com.minitagbrasil.examplesqlite.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import br.com.minitagbrasil.examplesqlite.R;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepare();
    }

    private void prepare() {

        final Button addCar = (Button) findViewById(R.id.btnOpenPopup);

        addCar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this, CarActivity.class);
                startActivity(it);

            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO refresh the list of cars
        Toast.makeText(this, "On Resume...", Toast.LENGTH_SHORT).show();
    }
}
