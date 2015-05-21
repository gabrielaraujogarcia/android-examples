package br.com.minitagbrasil.exampleappmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ggarcia on 20/05/15.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //create event to the click on buttom of simple menu
        doSimpleMenu();
    }

    private void doSimpleMenu(){

        Button simpleMenu = (Button) findViewById(R.id.btnSimpleMenu);

        simpleMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //start the activity
                Intent it = new Intent(MainActivity.this, SimpleMenuActivity.class);
                startActivity(it);

            }

        });

    }
}
