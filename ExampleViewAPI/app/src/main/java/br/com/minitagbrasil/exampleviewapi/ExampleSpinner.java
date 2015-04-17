package br.com.minitagbrasil.exampleviewapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Created by ggarcia on 16/04/15.
 */
public class ExampleSpinner extends Activity {

    private final int[] images =  {
            R.drawable.info_square_blue_48x48,
            R.drawable.info_square_green_48x48,
            R.drawable.info_square_red_48x48,
            R.drawable.info_square_yellow_48x48
    };

    private final String[] imageDescription = {
            "Blue square",
            "Green square",
            "Red square",
            "Yellow square"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        final ImageView img = (ImageView) findViewById(R.id.imgView);
        final Spinner dropdown = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, imageDescription);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                img.setImageResource(images[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
}
