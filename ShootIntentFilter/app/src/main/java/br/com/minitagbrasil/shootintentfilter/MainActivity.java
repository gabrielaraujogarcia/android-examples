package br.com.minitagbrasil.shootintentfilter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        displayMe();
        displayIt();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

}
