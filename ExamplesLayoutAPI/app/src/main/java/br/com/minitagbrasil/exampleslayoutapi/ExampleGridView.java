package br.com.minitagbrasil.exampleslayoutapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import br.com.minitagbrasil.exampleslayoutapi.adapters.ImageAdapter;

/**
 * Created by ggarcia on 03/04/15.
 */
public class ExampleGridView extends Activity {

    private int[] images = {
            R.drawable.smile_crazy_32x32,
            R.drawable.smile_crying_32x32,
            R.drawable.smile_glasses_32x32,
            R.drawable.smile_happy_32x32,
            R.drawable.smile_sad_32x32,
            R.drawable.smile_crazy_32x32,
            R.drawable.smile_crying_32x32,
            R.drawable.smile_glasses_32x32,
            R.drawable.smile_happy_32x32,
            R.drawable.smile_sad_32x32
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        GridView grid = (GridView) findViewById(R.id.grid1);

        grid.setAdapter(new ImageAdapter(this, images));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ExampleGridView.this, "You click on image " + position,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}
